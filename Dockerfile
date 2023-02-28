FROM openjdk:17-oracle as build
MAINTAINER mspoc.com
COPY target/product-0.0.1-SNAPSHOT.jar docker-test-product-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/docker-test-product-0.0.1-SNAPSHOT.jar"]