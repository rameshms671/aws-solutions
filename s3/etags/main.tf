terraform {
  required_providers {
    aws = {
      source = "hashicorp/aws"
      version = "6.0.0"
    }
  }
}

provider "aws" {
  # Configuration options
}

resource "aws_s3_bucket" "my-s3-bucket" {

}

resource "aws_s3_object" "object" {
  bucket = aws_s3_bucket.my-s3-bucket.id
  key    = "welcome"
  source = "welcome.txt"
  etag = filemd5("welcome.txt")
}