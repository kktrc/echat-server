package com.echat.controller;

import com.echat.store.StoreAPI;
import com.echat.utils.QiniuUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mosl on 2016/10/23.
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

  @RequestMapping("/vedio")
  @ResponseBody
  public Map<String,Object> uploadVedio(@RequestParam("file") MultipartFile file){
    Map<String,Object> map = new HashMap<>();
    try {
      QiniuUtils.uploadFile(file.getInputStream(),"",String.valueOf(System.currentTimeMillis()));
    } catch (IOException e) {
      e.printStackTrace();
    }
    map.put("status","ok");
    return map;
  }
}
