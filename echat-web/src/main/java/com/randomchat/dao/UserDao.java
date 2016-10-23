package com.randomchat.dao;

import com.randomchat.entity.User;

/**
 * Created by mosl on 2016/10/21.
 */
public interface UserDao {

  User find(long id);

  User find(String name);

  int insert(User user);

}
