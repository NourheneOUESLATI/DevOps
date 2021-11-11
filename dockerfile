FROM openjdk:8-jre-alpine
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \JAVA_OPTS=""
WORKDIR /app
COPY target/DevOps--5SE4-1.0.1.jar DevOps--5SE4-1.0.1.jar
EXPOSE 8181
CMD ["java", "-jar", "target/DevOps--5SE4-1.0.1.jar"]