FROM maven:3.8.6-openjdk-18-slim as BUILD
WORKDIR /home
COPY models/pom.xml .
RUN mvn verify --fail-never
COPY models/src ./src
RUN mvn clean install

FROM tomcat:10.0.26-jre17
COPY --from=BUILD /home/target/SalaDeElaboracion-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

CMD ["catalina.sh", "run"]
