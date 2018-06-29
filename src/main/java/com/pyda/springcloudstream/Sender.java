package com.pyda.springcloudstream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface Sender {
    String PROCESS_CREATED = "process-created";
    String PROCESS_UPDATED = "process-updated";
    String PROCESS_ENDED = "process-ended";

    @Output(Sender.PROCESS_CREATED)
    SubscribableChannel processCreated();

    @Output(Sender.PROCESS_UPDATED)
    SubscribableChannel processUpdated();

    @Output(Sender.PROCESS_ENDED)
    SubscribableChannel processEnded();
}
