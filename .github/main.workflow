workflow "Build and Push" {
  on = "push"
  resolves = ["GitHub Action for AWS"]
}

action "GitHub Action for AWS" {
  uses = "actions/aws/cli@51b5c9b60da75d1d3f97ff91ed2e4efc19dd5474"
  runs = "s3 ls s3://mybucket"
  secrets = ["AWS_ACCESS_KEY_ID", "AWS_SECRET_ACCESS_KEY"]
}
