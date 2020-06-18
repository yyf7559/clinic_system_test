FROM java:8
COPY target/*.jar trade.jar
RUN bash -c "touch /trade.jar"
EXPOSE 6001
ENTRYPOINT ["java","-jar","trade.jar"]