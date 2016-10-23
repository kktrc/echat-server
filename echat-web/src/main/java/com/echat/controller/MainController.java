package com.echat.controller;

import com.echat.dao.UserDao;
import com.echat.entity.User;
import org.apache.log4j.Logger;
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

  private static final Logger logger = Logger.getLogger(MainController.class);

  @Autowired
  private UserDao userDao;

  @ResponseBody
  @RequestMapping("/echo")
  public Map<String, Object> main() {

    logger.info("======>");

//    Main main = new Main();
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("good", "boy");
    map.put("你好","大家好");
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
