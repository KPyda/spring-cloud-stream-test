package com.pyda.springcloudstream;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class EventHandler {

    @StreamListener(value = Listener.PROCESS_CREATED)
    @SneakyThrows
    void eventReceivedHandler(ProcessCreatedEvent event) {
        Thread.sleep(1000);
        log.info("ProcessCreatedEvent: {}, received!", event);
    }

    @StreamListener(value = Listener.PROCESS_UPDATED)
    @SneakyThrows
    void eventReceivedHandler(ProcessUpdatedEvent event) {
        Thread.sleep(1000);
        log.info("ProcessUpdatedEvent: {}, received!", event);
    }

    @StreamListener(value = Listener.PROCESS_ENDED)
    @SneakyThrows
    void eventReceivedHandler(ProcessEndedEvent event) {
        Thread.sleep(1000);
        log.info("ProcessEndedEvent: {}, received!", event);
    }
}
