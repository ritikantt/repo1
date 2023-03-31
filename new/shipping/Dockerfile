FROM openjdk:17-oracle as build
MAINTAINER mspoc.com
COPY target/shipping-0.0.1-SNAPSHOT.jar shipping-0.0.1-SNAPSHOT.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar","/shipping-0.0.1-SNAPSHOT.jar"]
