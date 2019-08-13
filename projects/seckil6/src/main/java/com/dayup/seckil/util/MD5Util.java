package com.dayup.seckil.util;


import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

  public static String salt = "springboot";

  public static String md5(String str) {
    return DigestUtils.md5Hex(str);
  }

  // first encryption
  public static String inputToForm(String inputPass) {
    String str = inputPass + salt;
    return md5(str);
  }
  // second encryption
  public static String formToDB(String formPass, String dbSalt) {
    String str = dbSalt + formPass;
    return md5(str);
  }

  public static String inputToBack(String str) {
    return md5(str + salt);
  }

  public static String backToDb(String str, String dbSalt) {
    return md5(str + dbSalt);
  }

  public static String inputToDb(String inputPass, String dbSalt) {
    String formPass = inputToBack(inputPass);
    String dbPass = backToDb(formPass, dbSalt);
    return dbPass;

  }
}
