FROM openjdk:8-jre-alpine
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \JAVA_OPTS=""
WORKDIR /DevOps--5SE4
COPY target/DevOps--5SE4-1.0.jar DevOps--5SE4-1.0.jar
EXPOSE 8181
CMD ["java", "-jar", "target/DevOps--5SE4-1.0.jar"]