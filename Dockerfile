FROM openjdk:8
ADD zipkin-server-2.6.1-exec.jar zipkin.jar
ENTRYPOINT ["java","-jar","zipkin.jar"]
EXPOSE 9411
