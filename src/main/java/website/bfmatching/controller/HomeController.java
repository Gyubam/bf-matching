package website.bfmatching.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import website.bfmatching.entity.Board;
import website.bfmatching.repository.BoardRepository;
import website.bfmatching.repository.MemberRepository;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/")

    public String home(Model model) {

        List<Board> boardList = boardRepository.findAll();

        model.addAttribute("boardList", boardList);

        return "index";
    }


}
