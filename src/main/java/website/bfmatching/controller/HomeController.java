package website.bfmatching.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import website.bfmatching.config.auth.PrincipalDetails;
import website.bfmatching.entity.Board;
import website.bfmatching.entity.Member;
import website.bfmatching.login.SessionConst;
import website.bfmatching.repository.BoardRepository;
import website.bfmatching.repository.MemberRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/")

    public String home(@AuthenticationPrincipal
                       PrincipalDetails principalDetails, Model model,
                       HttpServletRequest request) {

        List<Board> boardList = boardRepository.findAll();

        // 세션 처리
        try {
            Member loginMember = principalDetails.getMember();

            model.addAttribute("loginMemberId", loginMember.getLoginId());

            HttpSession session = request.getSession();
            session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
            session.setAttribute("loginMemberId", loginMember.getLoginId());

        } catch (NullPointerException e) {

        }

        model.addAttribute("boardList", boardList);

        return "index";
    }


}
