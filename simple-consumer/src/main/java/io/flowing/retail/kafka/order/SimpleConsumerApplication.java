package io.flowing.retail.kafka.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleConsumerApplication {
  
  public static void main(String[] args) throws Exception {
    SpringApplication.run(SimpleConsumerApplication.class, args);
  }

}
