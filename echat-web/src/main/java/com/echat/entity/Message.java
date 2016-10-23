package com.echat.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jerry on 2016/10/23.
 * 消息
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

  private long id;
  private String content;
  private long timeStamp;
  private long userId;

}
