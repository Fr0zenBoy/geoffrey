FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/geoffrey-0.0.1-SNAPSHOT-standalone.jar /geoffrey/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/geoffrey/app.jar"]
