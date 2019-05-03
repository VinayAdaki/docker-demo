FROM openjdk:8
ADD ../target/mobile-app-services.jar mobile-app-services.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","mobile-app-services.jar"]