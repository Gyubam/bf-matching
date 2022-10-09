package website.bfmatching.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
public class ChatRoom extends BaseTimeEntity{

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String roomId;

    public ChatRoom(String name) {
        this.roomId = UUID.randomUUID().toString();
        this.name = name;
    }

    public ChatRoom() {
    }
}
