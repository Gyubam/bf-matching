package website.bfmatching.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import website.bfmatching.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findByTeamName(String teamName);
}
