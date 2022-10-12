package website.bfmatching;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import website.bfmatching.Dto.AddFormDto;
import website.bfmatching.entity.Board;
import website.bfmatching.entity.Member;
import website.bfmatching.file.UploadFile;
import website.bfmatching.service.BoardService;
import website.bfmatching.service.MemberService;

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



            AddFormDto addFormDto1 = new AddFormDto("유튜브 댓글 분석 서비스", "유튜브 영상의 댓글에 대한 전반적인 분석을 제공하는" +
                    "자동화된 웹사이트 입니다. 댓글에 대한 대표 키워드, 주요 타임라인 및 자연어 처리 모델을 통한 댓글의 긍정 부정 분석과 " +
                    " 감정 분석 결과를 시각적으로 제공합니다.", "sss1234", "Spring", "React", "Flask, NLP",
                    "스프링을 통해 백엔드를 구성합니다. MVC 모델로 아키텍쳐를 구성하며 DB의 경우 MYSQL을 사용합니다.",
                    "프론트엔드는 리액트를 통해 개발을 진행합니다. REST API를 통해 플라스크 서버와 JSON 데이터를 주고 받습니다.",
                    "NLP 모델링을 위해 Flask API서버를 구축하며 자연어처리를 위한 인공지능 모델을 구축합니다.",
                    "backend");

            AddFormDto addFormDto2 = new AddFormDto("SeeTrend", "실시간 검색어 및 검색 추이에 관한 정보를 제공하는 웹사이트 입니다.",
                    "sgb8170", "Spring", "네이버 검색어 트렌드 API", "Selenium 크롤링",
                    "스프링을 통해 웹 개발을 진행합니다.", "네이버 데이터랩 API 를 통해 검색어의 검색량 조회 및 그래프로 나타냅니다.",
                    "크롤링을 통해 실시간 검색어를 웹사이트의 실시간 검색어 정보를 추출합니다.",
                    "frontend");

            AddFormDto addFormDto3 = new AddFormDto("개발자 대시보드 사이트", "서버 DB관리를 위한 개발자 대시보드 입니다.",
                    "CoCo","BootStrap","React","MYSQL","test","test","test",
                    "backend");
            AddFormDto addFormDto4 = new AddFormDto("IT기기 광고 웹 사이트","특정 IT제품에 대한 광고 사이트 입니다.",
                    "ILLIYA","test","test","test","test","test","test",
                    "frontend");
            AddFormDto addFormDto5 = new AddFormDto("헬스케어 서비스 웹사이트","헬스케어 서비스를 제공하는 웹사이트 입니다.",
                    "koh2110","test","test","test","test","test","test",
                    "frontend");
            AddFormDto addFormDto6 = new AddFormDto("사진 공유 플랫폼","test",
                    "smith","test","test","test","test","test","test",
                    "frontend");
            AddFormDto addFormDto7 = new AddFormDto("엔진 통합 검색 웹 사이트","test",
                    "Jackson","test","test","test","test","test","test",
                    "backend");
            AddFormDto addFormDto8 = new AddFormDto("쇼핑몰 프로젝트","test"
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


        }
    }


}
