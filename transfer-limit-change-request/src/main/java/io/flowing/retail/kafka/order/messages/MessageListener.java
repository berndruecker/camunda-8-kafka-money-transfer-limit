package io.flowing.retail.kafka.order.messages;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.camunda.zeebe.client.ZeebeClient;
import io.flowing.retail.checkout.domain.Request;
import io.flowing.retail.kafka.order.process.TransferlimitChangeRequestPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

  @Autowired
  private ZeebeClient zeebe;
	
  @Autowired
  private ObjectMapper objectMapper;


  @KafkaListener(id = "transferlimit-change-request", topics = MessageSender.TOPIC_NAME)
  public void messageReceived(String messagePayloadJson, @Header("type") String messageType) throws Exception{
    if ("LimitChangeRequested".equals(messageType)) {
      startTransferlimitChangeRequest(objectMapper.readValue(messagePayloadJson, new TypeReference<Message<Request>>() {
      }));
    }
    else {
      System.out.println("Ignored message of type " + messageType );
    }
  }

  public void startTransferlimitChangeRequest(Message<Request> message) {
    // kick of a new flow instance
    System.out.println("New request placed, start process for " + message);

    TransferlimitChangeRequestPayload payload = new TransferlimitChangeRequestPayload();
    payload.setRequest(message.getData());
    payload.setTraceId(message.getTraceid());

    zeebe.newCreateInstanceCommand() //
            .bpmnProcessId("transfer-limit-change-request") //
            .latestVersion() //
            .variables(payload) //
            .send().join();
  }

}
