package io.github.rameshms671;

import java.security.NoSuchAlgorithmException;

import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;


public class Handler {
    private final S3Client s3Client;

    public Handler() throws NoSuchAlgorithmException {
        s3Client = DependencyFactory.s3Client();
    }

    public void sendRequest() {
        s3Client.putObject(PutObjectRequest.builder()
                        .bucket("my-client-encryption-msr")
                        .key("sample-encrypted-text")
                        .build(), RequestBody.fromString("Hello World"));

        ResponseBytes<GetObjectResponse> objectResponse = s3Client.getObjectAsBytes(builder -> builder
                .bucket("my-client-encryption-msr")
                .key("sample-encrypted-text"));
        String output = objectResponse.asUtf8String();
        System.out.println(output);
    }
}
