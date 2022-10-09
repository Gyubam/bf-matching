package website.bfmatching.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import website.bfmatching.Dto.MemberDto;
import website.bfmatching.service.MemberService;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@AllArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    //회원가입 폼
    @GetMapping("/members/new")
    public String addForm(@ModelAttribute("memberDto") MemberDto memberDto) {

        return "layout/login/addMemberForm";
    }

    //회원가입
    @PostMapping("/members/new")
    public String save(@Valid @ModelAttribute MemberDto memberDto,
                       BindingResult bindingResult) throws IOException {

        if (bindingResult.hasErrors()) {
            return "layout/login/addMemberForm";
        }

        String rawPassword = memberDto.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);

        MemberDto memberDtoForSave = new MemberDto(memberDto.getLoginId(), encPassword);

        memberService.registerDB(memberDtoForSave);

        return "redirect:/login";
    }

}
