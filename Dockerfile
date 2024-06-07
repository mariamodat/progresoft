FROM amazoncorretto:17
VOLUME /tmp

ARG JAR_FILE=target/progresoft-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} /application.jar

ENTRYPOINT ["java", "-Xmx2048M", "-jar", "/application.jar"]