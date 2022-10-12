package website.bfmatching.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.bfmatching.Dto.TeamDto;
import website.bfmatching.entity.Member;
import website.bfmatching.entity.Team;
import website.bfmatching.repository.MemberRepository;
import website.bfmatching.repository.TeamRepository;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long saveTeam(TeamDto teamDto, String loginId) {

        Team team = new Team(teamDto.getTeamName(), teamDto.getMaxNum(), 1);
        Member findMember = memberRepository.findByLoginId(loginId);

        teamRepository.save(team);
        findMember.changeTeam(team);

        return team.getId();

    }

    @Transactional
    public Long joinTeam(TeamDto teamDto, String loginId) {

        Team findTeam = teamRepository.findByTeamName(teamDto.getTeamName());
        Member findMember = memberRepository.findByLoginId(loginId);

        if (findTeam.getCurrentNum() < findTeam.getMaxNum()) {
            findMember.changeTeam(findTeam);
            findTeam.plusCurrentNum();
            return findTeam.getId();
        } else {
            return null;
        }



    }
}
