FROM openjdk:8
EXPOSE 8081
ADD target/soccerhub.jar soccerhub.jar
ENTRYPOINT ["java","-jar","/soccerhub.jar"]