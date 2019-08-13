package com.dayup.seckil.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="user")
public class User {
  @Id
  @Column(name="username")
  @NotBlank(message="username should not be empty")
  private String username;

  @Column(name="password", nullable = false)
  @NotBlank(message="password should not be empty")
  private String password;

  @Column(name="id", nullable = false)
  private long id;

  @Column(name="dbflag")
  private String dbflag;

  @NotBlank(message="please confirm password")
  public String getRepassword() {
    return repassword;
  }

  public String getDbflag() {
    return dbflag;
  }

  public void setDbflag(String dbflag) {
    this.dbflag = dbflag;
  }

  public void setRepassword(String repassword) {
    this.repassword = repassword;
  }

  private String repassword;



  public User() {}

  public User (String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }




}
