package io.flowing.retail.kafka.order.process;

import io.camunda.zeebe.spring.client.annotation.ZeebeVariable;
import io.camunda.zeebe.spring.client.annotation.ZeebeVariablesAsType;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import org.springframework.stereotype.Component;

@Component
public class AdjustTransferlimitAdapter {
  
  @ZeebeWorker(type = "adjustTransferLimit", autoComplete = true)
  public void handle(@ZeebeVariablesAsType TransferlimitChangeRequestPayload payload) {
    System.out.println("Now we would probably call a REST API :-) ");
  }
  
}
