package com.kh.bbs.domain.member.dao;

import com.kh.bbs.domain.entity.Member;

import java.util.Optional;

public interface MemberDAO {
  Long save(Member member);
  Optional<Member> findByEmail(String email);
  boolean isExistEmail(String email);
}