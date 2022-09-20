package website.bfmatching.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import website.bfmatching.entity.Member;
import website.bfmatching.login.LoginForm;
import website.bfmatching.login.LoginService;
import website.bfmatching.login.SessionConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;

    //로그인 폼
    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {

        return "layout/login/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginForm") LoginForm form,
                        BindingResult bindingResult,
                        @RequestParam(defaultValue = "/") String redirectURL,
                        HttpServletRequest request,
                        Model model) {

        if (bindingResult.hasErrors()) {
            return "layout/login/loginForm";
        }

        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());

        log.info("login? {}", loginMember);

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "layout/login/loginForm";
        }

        HttpSession session = request.getSession();

        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
        session.setAttribute("loginMemberId", loginMember.getLoginId());

        model.addAttribute("member", loginMember);

//        return "redirect:" + redirectURL;
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {

        //세션을 삭제한다.
        HttpSession session = request.getSession(false);  //세션이 없으면 재생성되면 안되므로 false로 함.

        if (session != null) {
            session.invalidate();  //세션 포함 그 안의 데이터 다 삭제.
            log.info("로그아웃 - 세션 삭제.");
        }
        return "redirect:/";
    }


}
