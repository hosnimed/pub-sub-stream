package com.sbm.cloud.stream.reactive.resource;

import com.sbm.cloud.stream.reactive.integration.OutputChannel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MessageResource {

    private final OutputChannel channel;

    @RequestMapping(method = RequestMethod.GET, value = "/sendMessage/{message}")
    public String sendMessage(@PathVariable String message) {
        log.info("Receive message {}", message);
        Message<String> msg = MessageBuilder.withPayload(message).build();
        channel.source().send(msg);
        return "Message " + message + " sent from the publishers";
    }
}
