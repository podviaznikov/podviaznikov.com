workflow "Build and Push" {
  on = "push"
  resolves = ["GitHub Action for AWS"]
}

action "GitHub Action for AWS" {
  uses = "actions/aws/cli@51b5c9b60da75d1d3f97ff91ed2e4efc19dd5474"
  args = "s3 cp content s3://cyclic.cc/$GITHUB_SHA --recursive"
  secrets = ["AWS_ACCESS_KEY_ID", "AWS_SECRET_ACCESS_KEY"]
}
