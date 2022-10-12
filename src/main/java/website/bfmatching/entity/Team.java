package website.bfmatching.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Team extends BaseTimeEntity{

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long id;

    private String teamName;

    private Integer maxNum;

    private Integer currentNum;

    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<Member> memberList = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, Integer maxNum, Integer currentNum) {
        this.teamName = teamName;
        this.maxNum = maxNum;
        this.currentNum = currentNum;
    }
}
