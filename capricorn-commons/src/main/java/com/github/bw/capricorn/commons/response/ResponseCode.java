package com.github.bw.capricorn.commons.response;

public enum ResponseCode {

  SUCCESS((short) 1000, "Response ok"),
  FAIL((short) 1001, "Response fail");

  final short code;
  final String desc;

  ResponseCode(short code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public short getCode() {
    return code;
  }

  public String getDesc() {
    return desc;
  }
}
