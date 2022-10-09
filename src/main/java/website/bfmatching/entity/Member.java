package website.bfmatching.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String loginId;
    private String password;
    private String username;

    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private List<Board> boardList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private List<Wish> wishList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String loginId, String password, String role) {
        this.loginId = loginId;
        this.password = password;
        this.role = role;
    }

    public Member(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }

    private String role;

    private String provider;
    private String providerId;

    public Member() {
    }

    @Builder
    public Member(String username, String loginId, String password, String role, String provider, String providerId) {

        this.username = username;
        this.loginId = loginId;
        this.password = password;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
    }
}
