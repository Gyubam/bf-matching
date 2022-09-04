package website.bfmatching.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
public class LoginController {


    //로그인 폼
    @GetMapping("/login")
    public String loginForm() {

        return "/layout/login/loginForm";
    }


}
