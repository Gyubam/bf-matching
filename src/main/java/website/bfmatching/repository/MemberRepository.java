package website.bfmatching.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import website.bfmatching.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByloginId(String loginId);


}
