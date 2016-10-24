package com.echat.controller;

import com.echat.store.StoreAPI;
import com.echat.utils.QiniuUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
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

  @RequestMapping("/file")
  @ResponseBody
  public Map<String,Object> fileUpload(HttpServletRequest request){
    Map<String,Object> map = new HashMap<>();
    long startTime=System.currentTimeMillis();   //获取开始时间
    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
    if(multipartResolver.isMultipart(request)){ //判断request是否有文件上传
      MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
      Iterator<String> ite = multiRequest.getFileNames();
      while(ite.hasNext()){
        MultipartFile file = multiRequest.getFile(ite.next());
        if(file!=null){
          try {
            QiniuUtils.uploadFile(file.getInputStream(),"",String.valueOf(System.currentTimeMillis()));
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    }
    long endTime=System.currentTimeMillis(); //获取结束时间
    System.out.println("上传文件共使用时间："+(endTime-startTime));
    map.put("time",(endTime - startTime)/1000);
    return map;
  }
}
