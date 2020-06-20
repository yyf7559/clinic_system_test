FROM java:8
COPY target/*.jar datasslave.jar
RUN bash -c "touch /datasslave.jar"
EXPOSE 8087
ENTRYPOINT ["java","-jar","datasslave.jar"]