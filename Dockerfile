FROM openjdk:11
MAINTAINER Ghofran Abdelwahab <prog.ghofranabdelwahab@gmail.com>
VOLUME /brain-tuck/logs /home/application/brain-tuck/logs
COPY target/base-*.jar base-app.jar
ENTRYPOINT ["java","-jar", "base-app.jar"]