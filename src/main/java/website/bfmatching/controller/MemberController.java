package website.bfmatching.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MemberController {

    //회원가입
    @GetMapping("/members/new")
    public String addForm() {

        return "/layout/login/addMemberForm";
    }

}
