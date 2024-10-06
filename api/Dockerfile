## Stage 1 : build with gradle builder image with native capabilities
FROM ghcr.io/graalvm/native-image:ol9-java17-22.3.2 AS build

# Install curl, unzip
RUN microdnf install -y curl unzip findutils \
    && microdnf clean all

# Install Gradle
ENV GRADLE_VERSION 8.3
RUN curl -sL https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip -o gradle.zip \
    && unzip gradle.zip -d /opt/gradle \
    && rm gradle.zip

ENV PATH="/opt/gradle/gradle-${GRADLE_VERSION}/bin:${PATH}"

COPY ./build.gradle ./build.gradle
COPY ./settings.gradle ./settings.gradle
COPY ./src ./src
RUN gradle build -Dquarkus.native.enabled=true -Dquarkus.package.jar.enabled=false
RUN ls -la /app/build/httpferret-1.0.0-native-image-source-jar/

## Stage 2 : create the docker final image
FROM registry.access.redhat.com/ubi9-minimal:9.2

WORKDIR /work
COPY --from=build /app/build/httpferret-1.0.0-native-image-source-jar/*-runner /work

# set up permissions for user `1001`
RUN chmod 775 /work \
  && chown -R 1001 /work \
  && chmod -R "g+rwX" /work \
  && chown -R 1001:root /work

RUN ls -la /work

EXPOSE 8080
USER 1001

CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]
