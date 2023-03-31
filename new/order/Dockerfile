FROM openjdk:17-oracle as build
MAINTAINER mspoc.com
COPY target/order-0.0.1-SNAPSHOT.jar order-0.0.1-SNAPSHOT.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/order-0.0.1-SNAPSHOT.jar"]
