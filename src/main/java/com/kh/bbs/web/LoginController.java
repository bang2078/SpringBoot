package com.kh.bbs.web;


import com.kh.bbs.domain.member.svc.MemberSVC;
import com.kh.bbs.web.api.Form.login.LoginForm;
import com.kh.bbs.web.login.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

  private final MemberSVC memberSVC;

  @GetMapping("/login")
  public String loginForm(Model model) {
    model.addAttribute("loginForm", new LoginForm());
    return "login/login";
  }

  @PostMapping("/login")
  public String login(@Valid @ModelAttribute LoginForm loginForm,
                      BindingResult bindingResult,
                      HttpServletRequest request) {

    if (bindingResult.hasErrors()) {
      return "login/login";
    }

    return memberSVC.login(loginForm.getEmail(), loginForm.getPasswd())
        .map(member -> {
          HttpSession session = request.getSession();
          session.setMaxInactiveInterval(1800); // 30분
          session.setAttribute(SessionConst.LOGIN_MEMBER, member);
          return "redirect:boards";
        })
        .orElseGet(() -> {
          bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
          return "login/login";
        });
  }

  @PostMapping("/logout")
  public String logout(HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    if (session != null) {
      session.invalidate();
    }
    return "redirect:boards";
  }
}


