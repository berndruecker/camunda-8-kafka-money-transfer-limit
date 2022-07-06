package io.flowing.retail.kafka.order.process;

import io.flowing.retail.checkout.domain.Request;

public class TransferlimitChangeRequestPayload {
  
  private io.flowing.retail.checkout.domain.Request request;
  private boolean manualApprovalNecessary = false;
  private boolean approved = false;

  public boolean isManualApprovalNecessary() {
    return manualApprovalNecessary;
  }

  public void setManualApprovalNecessary(boolean manualApprovalNecessary) {
    this.manualApprovalNecessary = manualApprovalNecessary;
  }

  public boolean isApproved() {
    return approved;
  }

  public void setApproved(boolean approved) {
    this.approved = approved;
  }

  public Request getRequest() {
    return request;
  }

  public void setRequest(Request request) {
    this.request = request;
  }
}
