package website.bfmatching.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import website.bfmatching.entity.Requirement;

public interface RequirementRepository extends JpaRepository<Requirement, Long> {
}
