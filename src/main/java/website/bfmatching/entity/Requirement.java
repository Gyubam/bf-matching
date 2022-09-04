package website.bfmatching.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Requirement {

    @Id
    @GeneratedValue
    @Column(name = "requirement_id")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    private String title;
    private String content;
    private String example;
}
