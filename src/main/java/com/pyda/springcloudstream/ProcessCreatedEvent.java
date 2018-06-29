package com.pyda.springcloudstream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
class ProcessCreatedEvent implements Event {

    private final String processId;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ProcessCreatedEvent(@JsonProperty("processId") String processId) {
        this.processId = processId;
    }

    @Override
    public String getProcessId() {
        return processId;
    }
}
