package com.pyda.springcloudstream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface Listener {
    String PROCESS_CREATED = "process-created-handler";
    String PROCESS_UPDATED = "process-updated-handler";
    String PROCESS_ENDED = "process-ended-handler";

    @Input(Listener.PROCESS_CREATED)
    MessageChannel processCreatedHandler();

    @Input(Listener.PROCESS_UPDATED)
    MessageChannel processUpdatedHandler();

    @Input(Listener.PROCESS_ENDED)
    MessageChannel processEndedHandler();
}
