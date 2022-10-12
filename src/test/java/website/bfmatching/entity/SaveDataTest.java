package website.bfmatching.entity;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import website.bfmatching.Dto.MemberDto;
import website.bfmatching.Dto.TeamDto;
import website.bfmatching.repository.MemberRepository;
import website.bfmatching.repository.TeamRepository;
import website.bfmatching.service.MemberService;
import website.bfmatching.service.TeamService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaveDataTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    MemberService memberService;

    @Autowired
    TeamService teamService;


    @Test
    public void saveMember() {

        //given
        Member member = new Member("asdf", "1234");

        MemberDto memberDto = new MemberDto("asdf", "1234");
        memberService.registerDB(memberDto);

        //when
        Member findMember = memberService.findByLoginId(memberDto.getLoginId());

        //then
        assertThat(findMember.getLoginId()).isEqualTo(member.getLoginId());
        assertThat(findMember.getPassword()).isEqualTo(member.getPassword());
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void saveMemberWithTeam() {
        //given
        TeamDto teamDto = new TeamDto("team1", 4);


        MemberDto memberDto = new MemberDto("asdf", "1234");
        memberService.registerDB(memberDto);


        //when

        teamService.saveTeam(teamDto, memberDto.getLoginId());

        Team findTeam = teamRepository.findByTeamName(teamDto.getTeamName());
        Member findMember = memberService.findByLoginId(memberDto.getLoginId());


        //then
        assertThat(findMember.getTeam().getTeamName()).isEqualTo(findTeam.getTeamName());

    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void joinTeam() {

        //given
        TeamDto teamDto = new TeamDto("team1", 4);


        MemberDto memberDto = new MemberDto("asdf", "1234");
        memberService.registerDB(memberDto);

        MemberDto memberDto2 = new MemberDto("asdf2", "1234");
        memberService.registerDB(memberDto2);

        teamService.saveTeam(teamDto, memberDto.getLoginId());

        //when
        Team findTeam = teamRepository.findByTeamName(teamDto.getTeamName());
        Member findMember = memberService.findByLoginId(memberDto.getLoginId());

        teamService.joinTeam(teamDto, memberDto2.getLoginId());

        Member findMember2 = memberService.findByLoginId(memberDto2.getLoginId());

        //then
        assertThat(findMember2.getTeam().getTeamName()).isEqualTo(findTeam.getTeamName());
        assertThat(findTeam.getCurrentNum()).isEqualTo(2);



    }
}