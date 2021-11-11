FROM openjdk:8-jdk-alpine
EXPOSE 8181
ADD target/DevOps--5SE4-1.0.3.jar DevOps--5SE4-1.0.3.jar
ENTRYPOINT ["java","-jar","/DevOps--5SE4-1.0.3.jar"]