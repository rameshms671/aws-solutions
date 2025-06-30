## Create an IAM system user
```sh
aws iam create-user --user-name my-system-user
```

## Add policy to Assume IAM Role
```sh
aws iam put-user-policy \
--user-name my-system-user \
--policy-name StsAssumePolicy \
--policy-document file://assume-policy.json
```

## Create access key for system-user
```sh
aws iam create-access-key --user-name my-system-user
```

## Configure access of the current system user
```sh
aws configure
```

## Update the profile to system
```sh
open ~/.aws/credentials
```

## Try to access s3 with system profile
```sh
aws s3 ls s3://my-sts-bucket-msr --profile system
```

```
An error occurred (AccessDenied) when calling the ListObjectsV2 operation: User: arn:aws:iam::906333058183:user/my-system-user is not authorized to perform: s3:ListBucket on resource: "arn:aws:s3:::my-sts-bucket-msr" because no identity-based policy allows the s3:ListBucket action
```

## Assume Role
```sh
aws sts assume-role \
--role-arn arn:aws:iam::906333058183:role/my-sts-stack-S3Role-ufAFQe6615Ej \
--role-session-name s3-access-temp \
--profile system
```

## Create a profile s3assumed with return access_id, secret and session token

## Execute the S3 list bucket command
```sh
aws s3 ls s3://my-sts-bucket-msr --profile s3assumed
```

## Clean up
```sh
./bin/delete.sh
aws s3 rm s3://my-sts-bucket-msr/welcome.txt
aws s3 rb s3://my-sts-bucket-msr
aws iam delete-user-policy --user-name my-system-user --policy-name StsAssumePolicy
aws iam delete-access-key --user-name my-system-user --access-key-id AKIA5GBNI6SDSMCEHFF6
aws iam delete-user --user-name my-system-user
```