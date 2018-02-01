FROM harbor:5000/skyform/tomcat:latest
MAINTAINER chenxf chenxfah@qq.com
ADD  ./hcsyncmdb.war  /home/skycloud/tomcat/webapps/
EXPOSE  8899
EXPOSE  20889
ENTRYPOINT  /home/skycloud/tomcat/bin/catalina.sh run