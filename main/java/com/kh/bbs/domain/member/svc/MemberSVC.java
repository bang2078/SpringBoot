package com.kh.bbs.domain.member.svc;

import com.kh.bbs.domain.entity.Member;

import java.util.Optional;

public interface MemberSVC {
  Long join(Member member);
  Optional<Member> login(String email, String passwd);
  boolean isExistEmail(String email);
}
