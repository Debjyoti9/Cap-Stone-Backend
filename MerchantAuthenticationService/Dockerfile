FROM openjdk:11-jre-slim
WORKDIR usr/src
ADD ./target/MerchantAuthenticationService-0.0.1-SNAPSHOT.jar /usr/src/MerchantAuthenticationService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","MerchantAuthenticationService-0.0.1-SNAPSHOT.jar"]