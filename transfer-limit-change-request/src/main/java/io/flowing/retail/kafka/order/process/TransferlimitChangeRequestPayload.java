package io.flowing.retail.kafka.order.process;

import io.flowing.retail.checkout.domain.Request;

public class TransferlimitChangeRequestPayload {

  private String traceId;
  private io.flowing.retail.checkout.domain.Request request;
  private boolean manualApprovalNecessary = false;
  private boolean approved = false;

  public String getTraceId() {
    return traceId;
  }

  public void setTraceId(String traceId) {
    this.traceId = traceId;
  }

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
