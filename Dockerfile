# Author Nilesh
FROM anapsix/alpine-java

EXPOSE 8080

RUN mkdir -p /var/app/code-server-api
COPY target/react-and-spring-data-rest-basic-0.0.1-SNAPSHOT.jar /var/app/code-server-api/

CMD java -jar /var/app/code-server-api/react-and-spring-data-rest-basic-0.0.1-SNAPSHOT.jar > log1.txt 2>&1



