FROM gradle:6.5.1-jdk11 as build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon 

FROM openjdk:11
EXPOSE 9730
RUN mkdir /app
COPY --from=build /home/gradle/src/ecommerce-lider-configuration/build/libs/ecommerce-lider-services-0.0.1-SNAPSHOT.jar /app/ecommerce-lider-services-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/ecommerce-lider-services-0.0.1-SNAPSHOT.jar"]
