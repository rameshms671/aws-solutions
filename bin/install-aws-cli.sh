#!/usr/bin/env bash

# https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html
cd /workspace
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
cd $GITPOD_REPO_ROOT