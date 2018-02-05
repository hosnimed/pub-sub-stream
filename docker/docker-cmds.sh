#!/usr/bin/env bash

#https://www.landoop.com/downloads/lenses-download-ok/
docker pull landoop/kafka-lenses-dev
docker run -p 3030:3030 --rm --net=host \
    -e EULA="https://dl.lenses.stream/d/?id=CHECK_YOUR_EMAIL_FOR_KEY" \
    landoop/kafka-lenses-dev

docker run --name activemq-artemis -d -p 8161:8161 -p 61616:61616 -e ARTEMIS_USERNAME="user" -e ARTEMIS_PASSWORD="password" -e ENABLE_JMX=true -e JMX_PORT=1199 -e JMX_RMI_PORT=1198 docker pull vromero/activemq-artemis:2.4.0