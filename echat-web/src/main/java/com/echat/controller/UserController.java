package com.echat.controller;

import com.echat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mosl on 2016/10/21.
 */
@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping("/login")
  @ResponseBody
  public Map<String, Object> login(String name, String pass) {

    boolean isLogin = userService.login(name, pass);
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("isLogin", isLogin);
    return map;
  }

  @RequestMapping("/register")
  @ResponseBody
  public Map<String, Object> register(String name, String pass) {

    boolean isRegister = userService.register(name, pass);
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("isRegister", isRegister);
    return map;
  }
}
