package com.sbm.cloudstream.subscriber.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface InputChannel {
    String SINK = "sink";

    @Input(SINK)
    SubscribableChannel sink();
}
