package com.kh.bbs.web.CommentForm;

import lombok.Data;

@Data
public class DetailForm {
  private Long commentId;
  private Long boardId;
  private String name;
  private String content;
}