package com.github.bw.capricorn.commons.response;

public enum InstanceHealthStatus {
  UP((byte) 0),
  DOWN((byte) 1),
  DEAD((byte) 2);

  private final byte status;

  InstanceHealthStatus(byte status) {
    this.status = status;
  }

  /**
   * 故意这样写的，因为数量少，所以用的 if, 否则应该用 values 遍历
   */
  public static InstanceHealthStatus getByStatus(byte status) {
    if (status == 0) {
      return UP;
    } else if (status == 1) {
      return DOWN;
    } else if (status == 2) {
      return DEAD;
    }
    return null;
  }

  public byte getStatus() {
    return status;
  }
}
