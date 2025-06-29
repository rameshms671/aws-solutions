
package io.github.rameshms671;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.encryption.s3.S3EncryptionClient;

/**
 * The module containing all dependencies required by the {@link Handler}.
 */
public class DependencyFactory {

    private DependencyFactory() {}

    /**
     * @return an instance of S3Client
     */
    public static S3Client s3Client() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        // Initialize with a key size (e.g., 2048 bits)
        keyGen.initialize(2048);
        // Generate the KeyPair
        KeyPair pair = keyGen.generateKeyPair();

        return S3EncryptionClient.builder()
                .region(Region.US_EAST_1)
                .rsaKeyPair(pair)
                .build();
    }
}
