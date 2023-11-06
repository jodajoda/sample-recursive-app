FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
COPY target/sample-recursive-app-0.0.1-SNAPSHOT.jar sample-app.jar
ENTRYPOINT ["java","-jar","/sample-app.jar"]