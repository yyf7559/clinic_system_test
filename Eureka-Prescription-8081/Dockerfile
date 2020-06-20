FROM java:8
COPY target/*.jar prescriptionslave.jar
RUN bash -c "touch /prescriptionslave.jar"
EXPOSE 8088
ENTRYPOINT ["java","-jar","prescriptionslave.jar"]