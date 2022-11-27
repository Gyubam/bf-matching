package website.bfmatching.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import website.bfmatching.Dto.MemberTeamDto;
import website.bfmatching.repository.MemberRepository;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
@Transactional
public class MemberTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    void saveMemberTest() {
        Member member = new Member("sgb8154", "11223344", "ROLE_USER");

        memberRepository.save(member);

        Member findMember = memberRepository.findByLoginId("sgb8154");

        Assertions.assertThat(findMember).isEqualTo(member);
    }

    @Test
    void findMemberQuerydsl() {
        List<MemberTeamDto> result = memberRepository.findAllMemberWithTeamByQuerydsl();

        for(MemberTeamDto dto : result){
            System.out.println(dto.getMemberId());
            System.out.println(dto.getLoginId());
            System.out.println(dto.getTeamId());
            System.out.println(dto.getTeamName());
        }
        System.out.println(result);
    }

}
