package com.kh.bbs.web.api.Form;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FindAllApi {
  private Long commentId ;
  private String name;
  private String content;
  private LocalDateTime createTime;
}