FROM openjdk:17

EXPOSE 8080

ADD target/spring_boot_rest_task1-0.0.1-SNAPSHOT.jar spring_boot_rest_task1.jar

ENTRYPOINT ["java", "-jar", "/spring_boot_rest_task1.jar"]

