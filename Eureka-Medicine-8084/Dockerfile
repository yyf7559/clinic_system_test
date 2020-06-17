FROM java:8
COPY target/*.jar medicines.jar
RUN bash -c "touch /medicines.jar"
EXPOSE 8084
ENTRYPOINT ["java","-jar","medicines.jar"]