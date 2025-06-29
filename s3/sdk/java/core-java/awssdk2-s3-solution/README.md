# Core-Java Example (Java-AWS S3 Integration using AWS SDK for Java 2.x)
## Documentation
https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/credentials-chain.html

This project contains a maven application with [AWS Java SDK 2.x](https://github.com/aws/aws-sdk-java-v2) dependencies.

## Prerequisites
- Java 1.8+
- Apache Maven
- GraalVM Native Image (optional)

## Maven Project Setup
Refer Latest Version from https://central.sonatype.com/artifact/software.amazon.awssdk/archetype-app-quickstart

```
mvn archetype:generate \
  -DarchetypeGroupId=software.amazon.awssdk \
  -DarchetypeArtifactId=archetype-app-quickstart \
  -DarchetypeVersion=2.31.69
```

### Enter below values
```
Define value for property 'service': s3
Define value for property 'httpClient' (should match expression '(url-connection-client|apache-client|netty-nio-client)'): apache-client
Define value for property 'nativeImage' (should match expression '(true|false)'): false
Define value for property 'credentialProvider' (should match expression '(default|identity-center)'): identity-center
Define value for property 'groupId': io.github.rameshms671
Define value for property 'artifactId': awssdk2-s3-solution         
Define value for property 'version' 1.0-SNAPSHOT: 1.0.0
Define value for property 'package' io.github.rameshms671: 
```

## Development

Below is the structure of the generated project.

```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── package
│   │   │       ├── App.java
│   │   │       ├── DependencyFactory.java
│   │   │       └── Handler.java
│   │   └── resources
│   │       └── simplelogger.properties
│   └── test
│       └── java
│           └── package
│               └── HandlerTest.java
```

- `App.java`: main entry of the application
- `DependencyFactory.java`: creates the SDK client
- `Handler.java`: you can invoke the api calls using the SDK client here.

#### Building the project
```
mvn clean package
```
#### Running the program
```
mvn compile exec:java -Dexec.mainClass=io.github.rameshms671.App
```
