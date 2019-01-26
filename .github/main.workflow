workflow "Build and Push" {
  on = "push"
  resolves = [
    "shell 2",
    "cycliccc/hugo",
  ]
}

action "cycliccc/hugo" {
  uses = "cycliccc/hugo@master"
}

action "shell 2" {
  uses = "actions/bin/sh@master"
  needs = ["cycliccc/hugo"]
  args = ["ls ${HOME}/"]
}
