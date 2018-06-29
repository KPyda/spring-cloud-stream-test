package com.pyda.springcloudstream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
class ProcessUpdatedEvent implements Event {

    private final String processId;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ProcessUpdatedEvent(@JsonProperty("processId") String processId) {
        this.processId = processId;
    }

    @Override
    public String getProcessId() {
        return processId;
    }
}
