package website.bfmatching.repository.querydsl;

import website.bfmatching.Dto.MemberDto;
import website.bfmatching.Dto.MemberTeamDto;

import java.util.List;

public interface MemberRepositoryQuerydsl {

    List<MemberTeamDto> findAllMemberWithTeamByQuerydsl();
}
