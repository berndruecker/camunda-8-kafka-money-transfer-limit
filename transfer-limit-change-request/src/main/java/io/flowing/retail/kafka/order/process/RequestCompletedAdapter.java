package io.flowing.retail.kafka.order.process;

import io.camunda.zeebe.spring.client.annotation.ZeebeVariable;
import io.camunda.zeebe.spring.client.annotation.ZeebeVariablesAsType;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import io.flowing.retail.kafka.order.messages.Message;
import io.flowing.retail.kafka.order.messages.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestCompletedAdapter {
  
  @Autowired
  private MessageSender messageSender;

  @ZeebeWorker(type = "emitChangeExecuted", autoComplete = true)
  public void handle(@ZeebeVariablesAsType TransferlimitChangeRequestPayload payload) {
    messageSender.send( //
        new Message<io.flowing.retail.checkout.domain.Request>( //
            "TransferlimitAdjustedEvent", //
                payload.getTraceId(),
                payload.getRequest()));
  }

  

}
