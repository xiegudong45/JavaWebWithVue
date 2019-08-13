package com.dayup.seckil.base.result;

public enum ResultCode {

  SUCCESS(200, "success"),
  FAIL(500, "failure"),
  USER_LOGIN_ERROR(500201, "login failure, wrong username or password"),

  SECKILL_LINE_UP(500100, "You are in queue."),
  SECKILL_NO_QUOTE(500101, "Sorry, the course is full."),
  SECKILL_BOUGHT(500102, "You have already bought the course, please check " +
          "your order."),
  SECKILL_PATH_ERROR(500104, "Wrong address!"),
  SECKILL_IP_OUTMAX(500105, "You have requsted too many times!");


  private Integer code;

  private String message;

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  ResultCode(Integer code, String message) {
    this.code = code;
    this.message = message;
  }
}
