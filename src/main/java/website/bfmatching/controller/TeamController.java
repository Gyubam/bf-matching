package website.bfmatching.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import website.bfmatching.Dto.AddTeamDto;
import website.bfmatching.Dto.TeamDto;
import website.bfmatching.config.auth.PrincipalDetails;
import website.bfmatching.entity.Member;
import website.bfmatching.entity.Team;
import website.bfmatching.login.SessionConst;
import website.bfmatching.service.MemberService;
import website.bfmatching.service.TeamService;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;
    private final MemberService memberService;

    @GetMapping("/team")
    public String teamList(Model model) {

        List<Team> teamList = teamService.findAll();

        model.addAttribute("teamList", teamList);

        return "layout/team/teamList";
    }

    @GetMapping("/team/{teamId}")
    public String teamInfo(@PathVariable("teamId") Long teamId,
                           Model model) {

        Team team = teamService.findById(teamId);
        List<Member> teamMembers = memberService.findByTeamId(teamId);

        model.addAttribute("team", team);
        model.addAttribute("teamMembers", teamMembers);

        List<Member> memberList = team.getMemberList();
        for (Member member : memberList) {
            System.out.println("member = " + member.getLoginId());
        }

        return "layout/team/teamInfo";
    }

    @GetMapping("/team/{teamId}/join")
    public String teamJoin(@AuthenticationPrincipal PrincipalDetails principalDetails,
                           @PathVariable("teamId") Long teamId,
                           Model model) {

        Member loginMember = principalDetails.getMember();

        Team findTeam = teamService.findById(teamId);

        TeamDto teamDto = new TeamDto(findTeam.getTeamName(), findTeam.getMaxNum());

        Long joinTeamId = teamService.joinTeam(teamDto, loginMember.getLoginId());

        return "redirect:/team";
    }

    @GetMapping("/team/add")
    public String teamAddForm(@ModelAttribute("addTeamDto") AddTeamDto addTeamDto) {

        return "layout/team/addTeamForm";
    }

    @PostMapping("/team/add")
    public String teamAdd(@AuthenticationPrincipal PrincipalDetails principalDetails,
                          @ModelAttribute("addTeamDto") AddTeamDto addTeamDto) {

        Member loginMember = principalDetails.getMember();

        TeamDto teamDto = new TeamDto(addTeamDto.getTeamName(), addTeamDto.getMaxNum());

        teamService.saveTeam(teamDto, loginMember.getLoginId());

        return "redirect:/team";
    }
}
