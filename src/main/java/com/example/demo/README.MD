#How to build a native application as a Docker image
To Build a native Docker image with Maven simply execute:

```
mvn -Pnative spring-boot:build-image
```
To start the image with Docker after the build:

```
docker run --rm -p 8080:8080 docker.io/library/spring-batch-5-native-images:0.0.1-SNAPSHOT
```