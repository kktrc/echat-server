package com.echat.store;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Recorder;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.persistent.FileRecorder;
import com.qiniu.util.Auth;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by jerry on 2016/10/23.
 * 存储API
 */
public class StoreAPI {

  private static Properties properties = new Properties();

  static{
    InputStream in = StoreAPI.class.getClassLoader().getResourceAsStream("qiniu.properties");
    try {
      properties.load(in);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //设置好账号的ACCESS_KEY和SECRET_KEY
  String ACCESS_KEY = properties.getProperty("APP_KEY");
  String SECRET_KEY = properties.getProperty("SECRET_KEY");
  //要上传的空间
  String bucketname = "imges";
  //上传到七牛后保存的文件名
  String key = "my-java.mp4";
  //上传文件的路径
  String FilePath = "/Users/mosl/Downloads/play.mp4";
  //密钥配置
  Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
  //创建上传对象
  UploadManager uploadManager = new UploadManager();

  //简单上传，使用默认策略，只需要设置上传的空间名就可以了
  public String getUpToken(){
    return auth.uploadToken(bucketname);
  }

  public void upload() throws IOException{
    try {
      //调用put方法上传
      Response res = uploadManager.put(FilePath, key, getUpToken());
      //打印返回的信息
      System.out.println(res.bodyString());
    } catch (QiniuException e) {
      Response r = e.response;
      // 请求失败时打印的异常的信息
      System.out.println(r.toString());
      try {
        //响应的文本信息
        System.out.println(r.bodyString());
      } catch (QiniuException e1) {
        //ignore
      }
    }
  }

  public void upload(InputStream in) throws IOException {

    String recordPath = "/.../...";
    //实例化recorder对象
    Recorder recorder = new FileRecorder(recordPath);
    //实例化上传对象，并且传入一个recorder对象
    UploadManager uploadManager = new UploadManager(recorder);
    try {
      //调用put方法上传
      Response res = uploadManager.put("path/file", "key", getUpToken());
      //打印返回的信息
      System.out.println(res.bodyString());
    } catch (QiniuException e) {
      Response r = e.response;
      // 请求失败时打印的异常的信息
      System.out.println(r.toString());
      try {
        //响应的文本信息
        System.out.println(r.bodyString());
      } catch (QiniuException e1) {
        //ignore
      }
    }
  }


  public void upload(File file, String fileName) throws QiniuException {
    uploadManager.put(file,fileName,getUpToken());
  }


  public static void main(String args[]) throws IOException{
    new StoreAPI().upload();
  }

}
