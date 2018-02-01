#/bin/sh

#https://www.landoop.com/downloads/lenses-download-ok/
docker pull landoop/kafka-lenses-dev
docker run -p 3030:3030 --rm --net=host \
    -e EULA="https://dl.lenses.stream/d/?id=CHECK_YOUR_EMAIL_FOR_KEY" \
    landoop/kafka-lenses-dev

docker run -e ADV_HOST=192.168.163.210 -e EULA="https://dl.lenses.stream/d/?id=e4aea201-af91-4049-97c4-0f499b6d74c0" --rm -p 3030:3030 -p 9092:9092 -p 2181:2181 -p 8081:8081 -p 9581:9581 -p 9582:9582 -p 9584:9584 -p 9585:9585 landoop/kafka-lenses-dev

docker run --name activemq-artemis -d -p 8161:8161 -p 61616:61616 -e ARTEMIS_USERNAME="user" -e ARTEMIS_PASSWORD="password" -e ENABLE_JMX=true -e JMX_PORT=1199 -e JMX_RMI_PORT=1198 docker pull vromero/activemq-artemis:1.5.5