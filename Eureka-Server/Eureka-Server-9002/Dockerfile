FROM java:8
COPY target/*.jar server2.jar
RUN bash -c "touch /server2.jar"
EXPOSE 9002
ENTRYPOINT ["java","-jar","server2.jar"]