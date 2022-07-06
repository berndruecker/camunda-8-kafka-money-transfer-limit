package io.flowing.retail.checkout.rest;

import io.flowing.retail.checkout.domain.Request;
import io.flowing.retail.checkout.messages.Message;
import io.flowing.retail.checkout.messages.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class ShopRestController {
  
  @Autowired
  private MessageSender messageSender;
  
  @RequestMapping(path = "/api/moneytransfer/limit", method = PUT)
  public String placeRequest(@RequestParam(value = "newLimit") String newLimit) {
    
    Request request = new Request();
    request.setNewLimit(newLimit);
    // TODO....

    Message<Request> message = new Message<Request>("LimitChangeRequested", request);
    messageSender.send(message);
        
    // note that we cannot easily return an order id here - as everything is asynchronous
    // and blocking the client is not what we want.
    // but we return an own correlationId which can be used in the UI to show status maybe later
    return "{\"traceId\": \"" + message.getTraceid() + "\"}";
  }

}