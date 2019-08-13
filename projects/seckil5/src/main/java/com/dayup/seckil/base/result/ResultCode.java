package com.dayup.seckil.base.result;

public enum ResultCode {

  SUCCESS(200, "success"),
  FAIL(500, "failure"),
  USER_LOGIN_ERROR(500201, "login failure, wrong username or password");

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
