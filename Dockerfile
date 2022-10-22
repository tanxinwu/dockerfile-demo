# syntax=docker/dockerfile:1
FROM circleci/jdk8:0.1.1
WORKDIR /opt
COPY  target/dockerfile-demo-0.0.1-SNAPSHOT.jar  /opt
EXPOSE 8081
CMD java -jar dockerfile-demo-0.0.1-SNAPSHOT.jar

RUN java -version

LABEL version="1.0.0" description="dome" by="lebron"
