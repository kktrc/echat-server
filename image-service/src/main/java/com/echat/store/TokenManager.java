package com.echat.store;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by mosl on 2016/10/23.
 */
public class TokenManager {

  private static Properties properties = new Properties();

  private static String QINIU_APP_KEY = "APP_KEY";
  private static String QINIU_SECRET_KEY = "SECRET_KEY";
  private static String BUCKET_KEY = "BUCKET_KEY";

  static {
    InputStream in = StoreAPI.class.getClassLoader().getResourceAsStream("qiniu.properties");
    try {
      properties.load(in);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static String get(String key){
    return properties.getProperty(key);
  }

  public static String qiniuKey(){
    return get(QINIU_APP_KEY);
  }

  public static String qiniuSecretKey(){
    return get(QINIU_SECRET_KEY);
  }

  public static String bucket(){
    return get(BUCKET_KEY);
  }

}
