FROM tomcat:9-jre8-alpine

RUN apk --update add curl ca-certificates tar 
RUN set -x \
    && mkdir /home/mysql \
    && curl -fSL https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.23.tar.gz -o /home/mysql/mysql-connector.jar \
    && cd /home/mysql \
    && tar -xzvf mysql-connector.jar \
    && pwd \
    && mkdir -p /usr/share/java \
    && mv /home/mysql/mysql-connector-java-8.0.23/mysql-connector-java-8.0.23.jar /usr/share/java/mysql-connector-java.jar \
    && cd /home \
    && rm -R *

RUN export CLASSPATH=$CLASSPATH:/usr/share/java/mysql-connector-java.jar

ADD ./target/GoogleDevOpsDemo-1.0.0-BUILD-SNAPSHOT.war /usr/local/tomcat/webapps/GoogleDevOpsDemo.war

EXPOSE 8080
