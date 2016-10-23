package com.randomchat.service.impl;

import com.randomchat.dao.UserDao;
import com.randomchat.entity.User;
import com.randomchat.service.UserService;
import com.randomchat.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by mosl on 2016/10/21.
 */
@Component
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  /**
   * 注册
   *
   * @param name
   * @param password
   * @return
   */
  public boolean register(String name, String password) {
    User user = new User();
    user.setName(name);
    user.setPassword(password);
    return userDao.insert(user) == 1;
  }

  /**
   * 登录
   *
   * @param name
   * @param password
   * @return
   */
  public boolean login(String name, String password) {
    User user = userDao.find(name);
    return MD5Utils.getMD5(password).equals(user.getPassword());
  }
}
