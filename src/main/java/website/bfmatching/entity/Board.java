package website.bfmatching.entity;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

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

    private String writerId;

    private String title;

    private String introduction;

    private String r_title1;
    private String r_title2;
    private String r_title3;

    private String r_content1;
    private String r_content2;
    private String r_content3;


//    private String imageName;
//    private MultipartFile attachFile;


    public Board(Member member, String writerId, String title,
                 String introduction, String r_title1,
                 String r_title2, String r_title3,
                 String r_content1, String r_content2,
                 String r_content3) {
        this.member = member;
        this.writerId = writerId;
        this.title = title;
        this.introduction = introduction;
        this.r_title1 = r_title1;
        this.r_title2 = r_title2;
        this.r_title3 = r_title3;
        this.r_content1 = r_content1;
        this.r_content2 = r_content2;
        this.r_content3 = r_content3;
    }

    public Board() {
    }
}
