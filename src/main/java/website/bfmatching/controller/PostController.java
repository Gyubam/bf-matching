package website.bfmatching.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import website.bfmatching.Dto.AddFormDto;
import website.bfmatching.entity.Member;
import website.bfmatching.repository.MemberRepository;
import website.bfmatching.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final MemberRepository memberRepository;
    private final BoardService boardService;

    @GetMapping("/post/add")
    public String addForm(@ModelAttribute("addFormDto") AddFormDto addFormDto) {

        return "/layout/addPostForm";
    }

    @PostMapping("/post/add")
    public String save(@ModelAttribute("addFormDto") AddFormDto addFormDto, HttpServletRequest request) {

        HttpSession session = request.getSession();

        Member findMember = memberRepository.findByLoginId(session.getAttribute("loginMemberId").toString());

        Long boardId = boardService.save(findMember.getLoginId(), addFormDto);

        return "redirect:/";

    }

    @GetMapping("/post/{postId}")
    public String info(@PathVariable("postId") Long boardId) {

        return "/layout/postInfo";
    }
}
