package website.bfmatching.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import website.bfmatching.entity.Member;
import website.bfmatching.repository.MemberRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ChatController {

    private final MemberRepository memberRepository;

    @GetMapping("/chat")
    public String chatGet(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();

        Member findMember = memberRepository.findByLoginId(session.getAttribute("loginMemberId").toString());

        model.addAttribute("username", findMember.getLoginId());

        log.info("chatGet()");

        return "layout/chat/chat";
    }
}
