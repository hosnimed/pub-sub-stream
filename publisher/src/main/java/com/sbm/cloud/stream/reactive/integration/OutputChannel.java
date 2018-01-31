package com.sbm.cloud.stream.reactive.integration;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OutputChannel {
    String SOURCE = "source";

    @Output(SOURCE)
    MessageChannel source();
}
