FROM java:8
COPY target/*.jar server3.jar
RUN bash -c "touch /server3.jar"
EXPOSE 9003
ENTRYPOINT ["java","-jar","server3.jar"]