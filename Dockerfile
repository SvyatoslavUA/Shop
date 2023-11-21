FROM openjdk:18

COPY /target/Shop-1.0-SNAPSHOT.jar shop.jar

COPY /src/main/resources/application.yaml /config/application.yml

ENTRYPOINT ["java", "-jar", "shop.jar", "--spring.config.location=file:/config/application.yml"]

