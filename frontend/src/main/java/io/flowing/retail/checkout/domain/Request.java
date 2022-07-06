package io.flowing.retail.checkout.domain;

import java.util.UUID;

public class Request {
  
  private String requestId = "checkout-generated-" + UUID.randomUUID().toString();
  private String customerId;
  private String newLimit;
  
  public String getRequestId() {
    return requestId;
  }
  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }
  public String getCustomerId() {
    return customerId;
  }
  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }
  public String getNewLimit() {
    return newLimit;
  }
  public void setNewLimit(String newLimit) {
    this.newLimit = newLimit;
  }

  
}
