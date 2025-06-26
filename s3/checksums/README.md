## Create a bucket
```
aws s3 mb s3://my-checksum-bucket-123
```

## Upload a file to the bucket
```
echo "Welcome Ramesh" > welcome.txt
aws s3 cp welcome.txt s3://my-checksum-bucket-123
```

## Check MD5 of the file
```
md5sum welcome.txt 
# 6d4ce2bac497585e6a708b667ac08f0b  welcome.txt
```

## Check Etag of the file
```
aws s3api head-object --bucket my-checksum-bucket-123 --key welcome.txt
```
### Output
```
{
    "AcceptRanges": "bytes",
    "LastModified": "2025-06-26T01:34:42+00:00",
    "ContentLength": 15,
    "ETag": "\"6d4ce2bac497585e6a708b667ac08f0b\"",
    "ContentType": "text/plain",
    "ServerSideEncryption": "AES256",
    "Metadata": {}
}
```

## Upload a file with a different checksum SHS256
### Correct checksum
```
openssl dgst -sha256 -binary welcome.txt | base64
# a7mh7fpGX7hdVci6BuneMejY6lv3cdWqKaVQY66CsZk=

aws s3api put-object \
--bucket my-checksum-bucket-123 \
--key welcomesha1_1 \
--body welcome.txt \
--checksum-algorithm SHA256 \
--checksum-sha256 a7mh7fpGX7hdVci6BuneMejY6lv3cdWqKaVQY66CsZk=
```
### Output
```
{
    "ETag": "\"2dd4e82d90fc51f68c830a9d0842bdc6\"",
    "ChecksumSHA256": "a7mh7fpGX7hdVci6BuneMejY6lv3cdWqKaVQY66CsZk=",
    "ChecksumType": "FULL_OBJECT",
    "ServerSideEncryption": "AES256"
}
```

### With Incorrect Checksum
```
openssl dgst -sha256 -binary welcome.txt | base64
# a7mh7fpGX7hdVci6BuneMejY6lv3cdWqKaVQY66CsZk=

aws s3api put-object \
--bucket my-checksum-bucket-123 \
--key welcomesha1 \
--body welcome.txt \
--checksum-algorithm SHA256 \
--checksum-sha256 OJJfNldn8nHAvRfRgB45o4vScf+kF6cFIk89y3jx7Xg=
```
### Output
```
An error occurred (BadDigest) when calling the PutObject operation: The SHA256 you specified did not match the calculated checksum.
```