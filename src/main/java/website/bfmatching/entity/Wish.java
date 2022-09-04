package website.bfmatching.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Wish {

    @Id
    @GeneratedValue
    @Column(name = "wish_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private Long boardId;

    private String boardTitle;


}
