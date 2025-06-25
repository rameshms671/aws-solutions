#!/usr/bin/env node
import * as cdk from 'aws-cdk-lib';
import { CdkS3SolutionStack } from '../lib/cdk-s3-solution-stack';

const app = new cdk.App();
new CdkS3SolutionStack(app, 'CdkS3SolutionStack');
