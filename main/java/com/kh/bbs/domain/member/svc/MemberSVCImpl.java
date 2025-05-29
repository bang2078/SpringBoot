package com.kh.bbs.domain.member.svc;

import com.kh.bbs.domain.entity.Member;
import com.kh.bbs.domain.member.dao.MemberDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberSVCImpl implements MemberSVC{
  private final MemberDAO memberDAO;

  @Override
  public Long join(Member member) {
    return memberDAO.save(member);
  }

  @Override
  public Optional<Member> login(String email, String passwd) {
    return memberDAO.findByEmail(email)
        .filter(m -> m.getPasswd().equals(passwd));
  }

  @Override
  public boolean isExistEmail(String email) {
    return memberDAO.isExistEmail(email);
  }
}