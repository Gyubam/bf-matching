package website.bfmatching.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import website.bfmatching.entity.Member;
import website.bfmatching.repository.querydsl.MemberRepositoryQuerydsl;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryQuerydsl {

    Member findByLoginId(String loginId);

    Optional<Member> findById(Long id);

    public Member findByUsername(String username);

    List<Member> findByTeamId(Long id);


}
