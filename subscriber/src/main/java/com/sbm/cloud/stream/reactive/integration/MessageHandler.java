package com.sbm.cloud.stream.reactive.integration;

import com.sbm.cloud.stream.reactive.message.InputChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@Slf4j
@EnableBinding(InputChannel.class)
public class MessageHandler {

    @StreamListener(InputChannel.SINK)
    public void handle(String message) {
        System.out.println("******************");
        System.out.println("At the Subscriber");
        System.out.println("******************");
        log.info("message received {}", message);
        System.out.println(message);
    }
}
