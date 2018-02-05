# Spring Cloud Stream Pub-Sub Multi Binder Demo (Rabbit & Kafka)
  A sample project to demonstrate Spring Cloud Stream (Source => Processor => Sink) asynchronous communication
  
# Introduction
- The project is configured to run with profiles :
+ `rabbit` (Rabbit Binder)
+ `kafka` (Kafka Binder)

# Technologies
- Java 8
- Maven 3
- Spring Boot: 2.0.0.RC1
- RabbitMQ 3.7.2
- Apache Kafka Client 1.0.0

# Pipeline Overview
- The following figure describe the global overview of the pipeline 

![Pipeline Overview](./pipeline-overview.png "Pipeline Overview")

# Run the project with `rabbit` profile

```sh
$ ${publisher} mvn spring-boot:run -Dspring.profiles.active=rabbit
$ ${processor} mvn spring-boot:run -Dspring.profiles.active=rabbit
$ ${subscriber} mvn spring-boot:run -Dspring.profiles.active=rabbit
```

# Run the project with `kafka` profile

```sh
$ ${publisher} mvn spring-boot:run -Dspring.profiles.active=kafka
$ ${processor} mvn spring-boot:run -Dspring.profiles.active=kafka
$ ${subscriber} mvn spring-boot:run -Dspring.profiles.active=kafka
```

# TODO
. Add Pojo Support


# References

- https://docs.spring.io/spring-cloud-stream/docs/current-SNAPSHOT/reference/htmlsingle/ 
- https://github.com/spring-cloud/spring-cloud-stream-samples
- https://github.com/ignacioSuay/spring-stream