package com.pyda.springcloudstream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
class ProcessController {

    private final Sender sender;

    ProcessController(Sender sender) {
        this.sender = sender;
    }

    @PutMapping("/processes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void sendStartProcessEvent(@PathVariable String id) {
        ProcessCreatedEvent payload = new ProcessCreatedEvent(id);
        sender.processCreated()
              .send(MessageBuilder.withPayload(payload)
                                  .build());
        log.info("ProcessCreatedEvent: {}", payload);
    }

    @PutMapping("/processes/{id}/updates")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void sendUpdateProcessEvent(@PathVariable String id) {
        ProcessUpdatedEvent payload = new ProcessUpdatedEvent(id);
        sender.processUpdated()
              .send(MessageBuilder.withPayload(payload)
                                  .build());
        log.info("ProcessUpdatedEvent: {}", payload);
    }

    @PutMapping("/processes/{id}/ends")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void sendEndProcessEvent(@PathVariable String id) {
        ProcessEndedEvent payload = new ProcessEndedEvent(id);
        sender.processEnded()
              .send(MessageBuilder.withPayload(payload)
                                  .build());
        log.info("ProcessUpdatedEvent: {}", payload);
    }

}
