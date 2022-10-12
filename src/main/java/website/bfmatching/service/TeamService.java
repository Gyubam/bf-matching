package website.bfmatching.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import website.bfmatching.Dto.TeamDto;
import website.bfmatching.entity.Team;
import website.bfmatching.repository.TeamRepository;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public void save(TeamDto teamDto) {
        Team team = new Team(teamDto.getTeamName(), teamDto.getMaxNum(), 1);

        teamRepository.save(team);

    }
}
