package io.flowing.retail.kafka.order;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

  public static final String TOPIC_NAME = "moneytransfer";

  @KafkaListener(id = "simple-consumer", topics = TOPIC_NAME)
  public void messageReceived(String messagePayloadJson, @Header("type") String messageType) throws Exception{
      System.out.println("Got message " + messagePayloadJson );
  }


}
