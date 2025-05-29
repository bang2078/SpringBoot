package com.kh.bbs.domain.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
  private Long commentId ;
  private String name;
  private String content;
  private LocalDateTime createTime;
  private Long boardId;
}
