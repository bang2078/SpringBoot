package com.kh.bbs.domain.comment.dao;

import com.kh.bbs.domain.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentDAO {
  //등록
  Long save(Long id , Comment comment);

  //수정
  Long update(Long id ,Comment comment);

  //삭제
  String delete (Long id);

  //목록
  List<Comment> findAll(Integer pid , Integer pageNo , Integer numOfRows);

  int getTotalCount(Integer pid);

  //조회
  Optional<Comment> detail(Long id);
}