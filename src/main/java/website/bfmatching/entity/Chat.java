package website.bfmatching.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashMap;

@Entity
@Getter
@ToString
public class Chat extends BaseTimeEntity{

    @Id
    @GeneratedValue
    @Column(name = "chat_id")
    private Long id;

    @Column(name = "room_id")
    private String roomId;

    private String writer;

    private String text;

    public Chat(String roomId, String writer, String text) {
        this.roomId = roomId;
        this.writer = writer;
        this.text = text;
    }

    public Chat() {
    }
}
