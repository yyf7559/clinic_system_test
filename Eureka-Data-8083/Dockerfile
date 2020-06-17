FROM java:8
COPY target/*.jar datas.jar
RUN bash -c "touch /datas.jar"
EXPOSE 8083
ENTRYPOINT ["java","-jar","datas.jar"]