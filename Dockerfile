FROM openjdk:11-jre

COPY ./build/libs/app-*.jar ./app-k8s.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app-k8s.jar"]