package com.sbm.cloudstream.subscriber.integration;

import com.sbm.cloudstream.subscriber.message.InputChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@Slf4j
@EnableBinding(InputChannel.class)
public class MessageHandler {

    @StreamListener(InputChannel.SINK)
    public void handle(String message) {
        log.info("message received {}", message);
        System.out.println(message);
    }
}
