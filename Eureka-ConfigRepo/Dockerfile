FROM java:8
COPY target/*.jar config.jar
RUN bash -c "touch /config.jar"
EXPOSE 6001
ENTRYPOINT ["java","-jar","config.jar"]