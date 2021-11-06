FROM maven:3.8.2-jdk-8

WORKDIR /DevOps--5SE4
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run