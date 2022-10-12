package website.bfmatching.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import website.bfmatching.entity.Team;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findByTeamName(String teamName);

    @Override
    @EntityGraph(attributePaths = {"memberList"})
    List<Team> findAll();
}
