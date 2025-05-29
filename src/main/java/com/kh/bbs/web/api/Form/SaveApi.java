package com.kh.bbs.web.api.Form;

import lombok.Data;

@Data
public class SaveApi {
  private String name;
  private String content;
  private Long boardId;
}