#/bin/sh

docker run --name activemq-artemis -d -p 8161:8161 -p 61616:61616 -e ARTEMIS_USERNAME="user" -e ARTEMIS_PASSWORD="password" -e ENABLE_JMX=true -e JMX_PORT=1199 -e JMX_RMI_PORT=1198 docker pull vromero/activemq-artemis:1.5.5