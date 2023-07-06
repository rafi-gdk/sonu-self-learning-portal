FROM openjdk:19-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} sonu-self-learning-portal.jar
ENTRYPOINT ["java","-jar","/sonu-self-learning-portal.jar"]