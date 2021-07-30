FROM openjdk

WORKDIR /app

COPY target/${JAR_FILE} /app/geek-store-backend.jar

ENTRYPOINT ["java","-jar","/geek-store-backend.jar"]