package com.randomchat.controller;

import com.easemob.server.Main;
import com.easemob.server.api.RestAPI;
import com.randomchat.dao.UserDao;
import com.randomchat.entity.User;
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
@RequestMapping("/main")
public class MainController {

  @Autowired
  private UserDao userDao;

  @ResponseBody
  @RequestMapping("/echo")
  public Map<String, Object> main() {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("good", "boy");
    return map;
  }

  @RequestMapping("/jsp")
  public String jsp() {
    return "index";
  }

  @RequestMapping("/query")
  @ResponseBody
  public Map<String, Object> query(long id) {
    Map<String, Object> map = new HashMap<String, Object>();
    User user = userDao.find(id);
    map.put("user", user);
    return map;
  }

}
