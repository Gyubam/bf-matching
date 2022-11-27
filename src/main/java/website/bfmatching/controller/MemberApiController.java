package website.bfmatching.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import website.bfmatching.Dto.MemberTeamDto;
import website.bfmatching.repository.MemberRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberRepository memberRepository;

    @GetMapping("/api/members")
    public List<MemberTeamDto> findAllMembersWithTeam() {

        return memberRepository.findAllMemberWithTeamByQuerydsl();
    }
}
