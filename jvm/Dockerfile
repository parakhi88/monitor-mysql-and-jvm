FROM java:openjdk-8-jdk-alpine
MAINTAINER pexea12

ENV SERVICE_PORT 5258
COPY SimpleServer.java SimpleServer.mf jmx_exporter.jar jmx-config.yaml /
RUN javac SimpleServer.java && \
    jar cmf SimpleServer.mf SimpleServer.jar SimpleServer.class SimpleServer.java

EXPOSE 8080
ENTRYPOINT java -javaagent:./jmx_exporter.jar=$SERVICE_PORT:jmx-config.yaml -jar SimpleServer.jar
