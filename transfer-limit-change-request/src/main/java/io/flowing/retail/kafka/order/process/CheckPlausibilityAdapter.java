package io.flowing.retail.kafka.order.process;

import io.camunda.zeebe.spring.client.annotation.ZeebeVariable;
import io.camunda.zeebe.spring.client.annotation.ZeebeVariablesAsType;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CheckPlausibilityAdapter {
  
  @ZeebeWorker(type = "checkPlausibility", autoComplete = true)
  public TransferlimitChangeRequestPayload handle(@ZeebeVariablesAsType TransferlimitChangeRequestPayload payload) {
    payload.setManualApprovalNecessary(true);
    return payload;
  }
  
}
