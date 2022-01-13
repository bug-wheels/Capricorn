package com.github.bw.capricorn.commons.response;

public class ErrorResponse extends Response {

  public static Response build(short code, String message) {
    ErrorResponse response = new ErrorResponse();
    response.setResponseCode(code);
    response.setMessage(message);
    return response;
  }

  public static Response build(ResponseCode responseCode) {
    return build(responseCode.getCode(), responseCode.getDesc());
  }

}
