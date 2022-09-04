FROM openjdk:17-alpine0
EXPOSE 89
EXPOSE 9876

WORKDIR /applications

COPY build/libs/demo-*-SNAPSHOT.jar /applications/demo.jar

ENTRYPOINT ["java","-jar", "demo.jar"]