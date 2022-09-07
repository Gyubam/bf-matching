package website.bfmatching.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import website.bfmatching.Dto.ChatRoomDto;
import website.bfmatching.entity.ChatRoom;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    ChatRoom findByRoomId(String roomId);

}
//@Repository
//public class ChatRoomRepository {
//
//    private Map<String, ChatRoomDto> chatRoomDTOMap;
//
//    @PostConstruct
//    private void init(){
//        chatRoomDTOMap = new LinkedHashMap<>();
//    }
//
//    public List<ChatRoomDto> findAllRooms(){
//        //채팅방 생성 순서 최근 순으로 반환
//        List<ChatRoomDto> result = new ArrayList<>(chatRoomDTOMap.values());
//        Collections.reverse(result);
//
//        return result;
//    }
//
//    public ChatRoomDto findRoomById(String id){
//        return chatRoomDTOMap.get(id);
//    }
//
//    public ChatRoomDto createChatRoomDTO(String name){
//        ChatRoomDto room = ChatRoomDto.create(name);
//        chatRoomDTOMap.put(room.getRoomId(), room);
//
//        return room;
//    }
//}
