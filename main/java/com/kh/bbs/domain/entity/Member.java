package com.kh.bbs.domain.entity;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class Member {

  private Long memberId; // 내부 관리 아이디 (PK)

  private String email; // 로그인 아이디

  private String passwd; // 로그인 비밀번호

  private String tel; // 연락처

  private String nickname; // 별칭

  private String gender; // 성별

  private String hobby; // 취미

  private String region; // 지역

  private String gubun; // 회원구분

  private byte[] pic; // 사진

  private Timestamp cdate; // 생성일시

  private Timestamp udate; // 수정일시
}
