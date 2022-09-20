package website.bfmatching.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import website.bfmatching.Dto.AddFormDto;
import website.bfmatching.entity.Board;
import website.bfmatching.entity.Member;
import website.bfmatching.file.FileStore;
import website.bfmatching.file.UploadFile;
import website.bfmatching.repository.BoardRepository;
import website.bfmatching.repository.MemberRepository;
import website.bfmatching.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;
    private final BoardService boardService;
    private final FileStore fileStore;


    @Value("${file.dir}")
    private String fileDir;

    @GetMapping("/post/add")
    public String addForm(@ModelAttribute("addFormDto") AddFormDto addFormDto) {

        return "layout/addPostForm";
    }

    @PostMapping("/post/add")
    public String save(@ModelAttribute("addFormDto") AddFormDto addFormDto,
                       HttpServletRequest request) throws IOException {

        HttpSession session = request.getSession();

        Member findMember = memberRepository.findByLoginId(session.getAttribute("loginMemberId").toString());
        UploadFile attachFile = fileStore.storeFile(addFormDto.getAttachFile());
        Long boardId = boardService.save(findMember.getLoginId(), addFormDto, attachFile);


        return "redirect:/";

    }

    @GetMapping("/post/{postId}")
    public String info(@PathVariable("postId") Long boardId, Model model) {

        Optional<Board> boardOptional = boardRepository.findById(boardId);


        if (boardOptional.isPresent()) {

            Board boardData = boardOptional.get();

            model.addAttribute("board", boardData);

            return "layout/postInfo";
        } else {
            return "layout/error/500";
        }


    }

    @GetMapping("/post/addd")
    public String Form() {

        return "layout/error/500";
    }

    @ResponseBody
    @GetMapping("/images/{filename}")
    public Resource downloadImage(@PathVariable String filename) throws MalformedURLException {
        return new UrlResource("file:" + fileStore.getFullPath(filename));
//        return new UrlResource(fileStore.getFullPath(filename));
    }
}
