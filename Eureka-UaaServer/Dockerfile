FROM java:8
COPY target/*.jar uaa.jar
RUN bash -c "touch /uaa.jar"
EXPOSE 5001
ENTRYPOINT ["java","-jar","uaa.jar"]