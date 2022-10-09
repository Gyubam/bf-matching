package website.bfmatching.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import website.bfmatching.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByLoginId(String loginId);

    Optional<Member> findById(Long id);

    public Member findByUsername(String username);


}
