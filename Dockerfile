FROM openjdk:17-alpine

EXPOSE 80
EXPOSE 9876

WORKDIR /applications

COPY build/libs/demo-*-SNAPSHOT.jar /applications/demo.jar

ENTRYPOINT ["java","-jar", "demo.jar"]