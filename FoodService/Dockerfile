FROM openjdk:11-jre-slim
WORKDIR usr/src
ADD ./target/FoodService-0.0.1-SNAPSHOT.jar /usr/src/FoodService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","FoodService-0.0.1-SNAPSHOT.jar"]