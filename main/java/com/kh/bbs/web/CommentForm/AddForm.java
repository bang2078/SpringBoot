package com.kh.bbs.web.CommentForm;

import lombok.Data;

@Data
public class AddForm {
  private Long boardId;
  private String name;
  private String content;
}