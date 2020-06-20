FROM java:8
COPY target/*.jar medicinesslave.jar
RUN bash -c "touch /medicinesslave.jar"
EXPOSE 8086
ENTRYPOINT ["java","-jar","medicinesslave.jar"]