FROM java:8
COPY target/*.jar server1.jar
RUN bash -c "touch /server1.jar"
EXPOSE 9001
ENTRYPOINT ["java","-jar","server1.jar"]