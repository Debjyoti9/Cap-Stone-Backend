FROM openjdk:11-jre-slim
WORKDIR usr/src
ADD ./target/FavouriteService-0.0.1-SNAPSHOT.jar /usr/src/FavouriteService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","FavouriteService-0.0.1-SNAPSHOT.jar"]