workflow "Build and Push" {
  on = "push"
  resolves = ["update cloudfront"]
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
  args = "cloudfront get-distribution-config --id E1TRGMU2X297HL > /tmp/distconfig_result.json; sed 's/OriginPath\": \".*\"/OriginPath\": \"/$GITHUB_SHA\"/g' /tmp/distconfig_result.json > /tmp/updated_distconfig.json; cat /tmp/updated_distconfig.json"
}
