FROM openjdk:18
COPY /target/Shop-1.0-SNAPSHOT.jar shop.jar
ENTRYPOINT ["java", "-jar", "shop.jar"]

