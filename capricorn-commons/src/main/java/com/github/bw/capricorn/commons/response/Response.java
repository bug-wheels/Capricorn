package com.github.bw.capricorn.commons.response;

public abstract class Response {

  short SUCCESS_CODE = ResponseCode.SUCCESS.getCode();

  short responseCode;
  String message;

  public boolean isSuccess() {
    return responseCode == SUCCESS_CODE;
  }

  public short getResponseCode() {
    return responseCode;
  }

  public void setResponseCode(short responseCode) {
    this.responseCode = responseCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
