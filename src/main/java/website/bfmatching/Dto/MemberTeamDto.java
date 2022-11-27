package website.bfmatching.Dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

import java.security.PrivateKey;

@Getter
@Setter
public class MemberTeamDto {

    private Long memberId;
    private String loginId;
    private Long teamId;
    private String teamName;

    @QueryProjection
    public MemberTeamDto(Long memberId, String loginId, Long teamId, String teamName) {
        this.memberId = memberId;
        this.loginId = loginId;
        this.teamId = teamId;
        this.teamName = teamName;
    }
}
