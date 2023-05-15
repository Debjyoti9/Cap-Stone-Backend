FROM openjdk:11-jre-slim
WORKDIR usr/src
ADD ./target/MerchantService-0.0.1-SNAPSHOT.jar /usr/src/MerchantService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","MerchantService-0.0.1-SNAPSHOT.jar"]
