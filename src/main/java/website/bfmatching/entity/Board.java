package website.bfmatching.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Board {

    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String writerName;

    private String title;

    private String introduction;

    @OneToMany(mappedBy = "board")
    private List<Requirement> requirements = new ArrayList<>();


}
