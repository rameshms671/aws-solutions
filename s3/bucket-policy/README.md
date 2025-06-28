## Create bucket
```
aws s3 mb s3://my-policy-bucket-msr
```

## Update Bucket Policy
https://awspolicygen.s3.amazonaws.com/policygen.html </br>
https://docs.aws.amazon.com/AmazonS3/latest/userguide/bucket-policies.html
```
aws s3api put-bucket-policy --bucket my-policy-bucket-msr --policy file://bucket-policy.json
```

## Access Bucket from different account
```
aws s3 ls s3://my-policy-bucket-msr
touch welcome.txt
aws s3 cp welcome.txt s3://my-policy-bucket-msr
```

## Clean up
```
aws s3 rm s3://my-policy-bucket-msr/welcome.txt
aws s3 rb s3://my-policy-bucket-msr
```