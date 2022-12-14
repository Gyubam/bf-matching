package website.bfmatching;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import website.bfmatching.Dto.AddFormDto;
import website.bfmatching.Dto.TeamDto;
import website.bfmatching.entity.Board;
import website.bfmatching.entity.Member;
import website.bfmatching.file.UploadFile;
import website.bfmatching.service.BoardService;
import website.bfmatching.service.MemberService;
import website.bfmatching.service.TeamService;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();

    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;
        private final BoardService boardService;
        private final MemberService memberService;
        private final TeamService teamService;

        public void dbInit1() {
            Member member1 = new Member("CoCo", "1234", "ROLE_USER");
            Member member2 = new Member("sgb8170", "1234", "ROLE_USER");
            Member member3 = new Member("koh2110", "1234", "ROLE_USER");
            Member member4 = new Member("ILLIYA", "12345", "ROLE_USER");
            Member member5 = new Member("Maker", "12345", "ROLE_USER");
            Member member6 = new Member("king33", "12345", "ROLE_USER");
            Member member7 = new Member("Jackson", "12345", "ROLE_USER");
            Member member8 = new Member("smith", "12345", "ROLE_USER");

            em.persist(member1);
            em.persist(member2);
            em.persist(member3);
            em.persist(member4);
            em.persist(member5);
            em.persist(member6);
            em.persist(member7);
            em.persist(member8);



            AddFormDto addFormDto1 = new AddFormDto("????????? ?????? ?????? ?????????", "????????? ????????? ????????? ?????? ???????????? ????????? ????????????" +
                    "???????????? ???????????? ?????????. ????????? ?????? ?????? ?????????, ?????? ???????????? ??? ????????? ?????? ????????? ?????? ????????? ?????? ?????? ????????? " +
                    " ?????? ?????? ????????? ??????????????? ???????????????.", "sss1234", "Spring", "React", "Flask, NLP",
                    "???????????? ?????? ???????????? ???????????????. MVC ????????? ??????????????? ???????????? DB??? ?????? MYSQL??? ???????????????.",
                    "?????????????????? ???????????? ?????? ????????? ???????????????. REST API??? ?????? ???????????? ????????? JSON ???????????? ?????? ????????????.",
                    "NLP ???????????? ?????? Flask API????????? ???????????? ?????????????????? ?????? ???????????? ????????? ???????????????.",
                    "backend");

            AddFormDto addFormDto2 = new AddFormDto("SeeTrend", "????????? ????????? ??? ?????? ????????? ?????? ????????? ???????????? ???????????? ?????????.",
                    "sgb8170", "Spring", "????????? ????????? ????????? API", "Selenium ?????????",
                    "???????????? ?????? ??? ????????? ???????????????.", "????????? ???????????? API ??? ?????? ???????????? ????????? ?????? ??? ???????????? ???????????????.",
                    "???????????? ?????? ????????? ???????????? ??????????????? ????????? ????????? ????????? ???????????????.",
                    "frontend");

            AddFormDto addFormDto3 = new AddFormDto("????????? ???????????? ?????????", "?????? DB????????? ?????? ????????? ???????????? ?????????.",
                    "CoCo","BootStrap","React","MYSQL","test","test","test",
                    "backend");
            AddFormDto addFormDto4 = new AddFormDto("IT?????? ?????? ??? ?????????","?????? IT????????? ?????? ?????? ????????? ?????????.",
                    "ILLIYA","test","test","test","test","test","test",
                    "frontend");
            AddFormDto addFormDto5 = new AddFormDto("???????????? ????????? ????????????","???????????? ???????????? ???????????? ???????????? ?????????.",
                    "koh2110","test","test","test","test","test","test",
                    "frontend");
            AddFormDto addFormDto6 = new AddFormDto("?????? ?????? ?????????","test",
                    "smith","test","test","test","test","test","test",
                    "frontend");
            AddFormDto addFormDto7 = new AddFormDto("?????? ?????? ?????? ??? ?????????","test",
                    "Jackson","test","test","test","test","test","test",
                    "backend");
            AddFormDto addFormDto8 = new AddFormDto("????????? ????????????","test"
                    ,"king33","test","test","test","test","test","test",
                    "backend");

            boardService.save(member1.getLoginId(), addFormDto1, new UploadFile("1","509d1deb-fc42-48dd-b24c-c93204f4190d.PNG"));
            boardService.save(member2.getLoginId(), addFormDto2, new UploadFile("1", "0f08909f-e55d-4214-8711-4ea3b23563b4.PNG"));
            boardService.save(member3.getLoginId(), addFormDto3, new UploadFile("1", "developers_page.PNG"));
            boardService.save(member4.getLoginId(), addFormDto4, new UploadFile("1", "smartphone_page.PNG"));
            boardService.save(member5.getLoginId(), addFormDto5, new UploadFile("1", "healthcare_page.PNG"));
            boardService.save(member6.getLoginId(), addFormDto6, new UploadFile("1", "photo_save_platform.PNG"));
            boardService.save(member7.getLoginId(), addFormDto7, new UploadFile("1", "integrate_search_service.PNG"));
            boardService.save(member8.getLoginId(), addFormDto8, new UploadFile("1", "shoppingmall_project.PNG"));

            TeamDto teamDto1 = new TeamDto("????????? ?????? ?????? ?????????", 4);
            TeamDto teamDto2 = new TeamDto("SeeTrend", 4);
            TeamDto teamDto3 = new TeamDto("????????? ???????????? ?????????", 2);
            TeamDto teamDto4 = new TeamDto("?????? ?????? ?????????", 5);
            TeamDto teamDto5 = new TeamDto("????????? ????????????", 4);

            teamService.saveTeam(teamDto1, member1.getLoginId());
            teamService.saveTeam(teamDto2, member2.getLoginId());
            teamService.saveTeam(teamDto3, member3.getLoginId());
            teamService.saveTeam(teamDto4, member4.getLoginId());

            teamService.joinTeam(teamDto1, member2.getLoginId());
            teamService.joinTeam(teamDto1, member3.getLoginId());
            teamService.joinTeam(teamDto2, member4.getLoginId());
            teamService.joinTeam(teamDto2, member5.getLoginId());
            teamService.joinTeam(teamDto3, member6.getLoginId());
            teamService.joinTeam(teamDto4, member7.getLoginId());
        }
    }


}
