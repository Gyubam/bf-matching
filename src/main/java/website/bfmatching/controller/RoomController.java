package website.bfmatching.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import website.bfmatching.entity.Chat;
import website.bfmatching.entity.ChatRoom;
import website.bfmatching.entity.Member;
import website.bfmatching.repository.ChatRepository;
import website.bfmatching.repository.ChatRoomRepository;
import website.bfmatching.repository.MemberRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/chat")
public class RoomController {

    private final ChatRoomRepository chatRoomRepository;
    private final MemberRepository memberRepository;
    private final ChatRepository chatRepository;

    //채팅방 목록 조회
    @GetMapping(value = "/rooms")
    public ModelAndView rooms(){

        log.info("# All Chat Rooms");
        ModelAndView mv = new ModelAndView("layout/chat/rooms");

//        mv.addObject("list", chatRoomRepository.findAllRooms());

        mv.addObject("list", chatRoomRepository.findAll());

        return mv;
    }

    //채팅방 개설
    @PostMapping(value = "/room")
    public String create(@RequestParam String name, RedirectAttributes rttr){

        log.info("# Create Chat Room , name: " + name);
//        rttr.addFlashAttribute("roomName", chatRoomRepository.createChatRoomDTO(name));
        ChatRoom save = chatRoomRepository.save(new ChatRoom(name));
        return "redirect:/chat/rooms";
    }

    //채팅방 조회
    @GetMapping("/room")
    public String getRoom(String roomId, Model model, HttpServletRequest request){

        List<Chat> chatList = chatRepository.findByRoomIdOrderById(roomId);


        log.info("# get Chat Room, roomID : " + roomId);
        HttpSession session = request.getSession();

        Member findMember = memberRepository.findByLoginId(session.getAttribute("loginMemberId").toString());

        model.addAttribute("username", findMember.getLoginId());
        model.addAttribute("room", chatRoomRepository.findByRoomId(roomId));
        model.addAttribute("chatList", chatList);

        return "layout/chat/room";
    }
}
