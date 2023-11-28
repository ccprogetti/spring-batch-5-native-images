# How to build a native application as a Docker image

To Build a native Docker image with Maven simply execute the following command from the root directory of the project:

```
mvn -Pnative spring-boot:build-image
```

You will need to have Maven, Docker and at least Java 17 installed on your machine.

 
To start the image with after the build simply run:

```
docker run --rm docker.io/library/spring-batch-5-native-images:0.0.1-SNAPSHOT
```