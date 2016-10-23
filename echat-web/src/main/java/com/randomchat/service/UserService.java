package com.randomchat.service;

import com.randomchat.entity.User;

/**
 * Created by mosl on 2016/10/21.
 */
public interface UserService {

  /**
   * 注册
   *
   * @param name
   * @param password
   * @return
   */
  boolean register(String name, String password);

  /**
   * 登录
   *
   * @param name
   * @param password
   * @return
   */
  boolean login(String name, String password);


}
