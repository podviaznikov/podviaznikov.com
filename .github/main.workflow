workflow "Build and Push" {
  on = "push"
  resolves = ["GitHub Action for AWS"]
}

action "upload to s3" {
  uses = "actions/aws/cli@51b5c9b60da75d1d3f97ff91ed2e4efc19dd5474"
  args = "s3 cp content s3://cyclic.cc/$GITHUB_SHA --recursive"
  secrets = ["AWS_ACCESS_KEY_ID", "AWS_SECRET_ACCESS_KEY"]
}

action "update cloudfront" {
  uses = "actions/aws/cli@51b5c9b60da75d1d3f97ff91ed2e4efc19dd5474"
  needs = ["upload to s3"]
  secrets = ["AWS_ACCESS_KEY_ID", "AWS_SECRET_ACCESS_KEY"]
  args = "cloudfront get-distribution-config --id E1TRGMU2X297HL > distconfig_result.json; SLASH='/'; ORIGIN_PATH=$SLASH$GITHUB_SHA;sed 's,OriginPath\": \".*\",OriginPath\": \"'$ORIGIN_PATH'\",g' distconfig_result.json > temp_config.json; jq .DistributionConfig temp_config.json > updated_config.json; cat updated_config.json; aws cloudfront update-distribution --if-match $(jq .ETag --raw-output distconfig_result.json) --id E1TRGMU2X297HL --distribution-config file://updated_config.json"
}

action "GitHub Action for AWS" {
  uses = "actions/aws/cli@aba0951d3bb681880614bbf0daa29b4a0c9d77b8"
  needs = ["update cloudfront"]
  args = "wait distribution-deployed --id E1TRGMU2X297HL"
}
