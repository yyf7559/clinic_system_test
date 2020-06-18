FROM java:8
COPY target/*.jar zuul.jar
RUN bash -c "touch /zuul.jar"
EXPOSE 7001
ENTRYPOINT ["java","-jar","zuul.jar"]