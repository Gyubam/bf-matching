package website.bfmatching;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import website.bfmatching.Dto.AddFormDto;
import website.bfmatching.entity.Member;
import website.bfmatching.file.UploadFile;
import website.bfmatching.service.BoardService;

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

        public void dbInit1() {
            Member member1 = new Member("sss1234", "1234");
            Member member2 = new Member("sgb8170", "1234");
            Member member3 = new Member("sss123456", "123456");
            Member member4 = new Member("sss1234567", "1234567");

            em.persist(member1);
            em.persist(member2);



            AddFormDto addFormDto1 = new AddFormDto("유튜브 댓글 분석 서비스", "유튜브 영상의 댓글에 대한 전반적인 분석을 제공하는" +
                    "자동화된 웹사이트 입니다.", "sss1234", "Spring", "React", "Flask, NLP",
                    "스프링을 통해 백엔드를 구성합니다. MVC 모델로 아키텍쳐를 구성하며 DB의 경우 MYSQL을 사용합니다.",
                    "프론트엔드는 리액트를 통해 개발을 진행합니다. REST API를 통해 플라스크 서버와 JSON 데이터를 주고 받습니다.",
                    "NLP 모델링을 위해 Flask API서버를 구축하며 자연어처리를 위한 인공지능 모델을 구축합니다.");

            AddFormDto addFormDto2 = new AddFormDto("SeeTrend", "실시간 검색어 및 검색 추이에 관한 정보를 제공하는 웹사이트 입니다.",
                    "sgb8170", "Spring", "네이버 검색어 트렌드 API", "Selenium 크롤링",
                    "스프링을 통해 웹 개발을 진행합니다.", "네이버 데이터랩 API 를 통해 검색어의 검색량 조회 및 그래프로 나타냅니다.",
                    "크롤링을 통해 실시간 검색어를 웹사이트의 실시간 검색어 정보를 추출합니다.");

            boardService.save(member1.getLoginId(), addFormDto1, new UploadFile("1","509d1deb-fc42-48dd-b24c-c93204f4190d.PNG"));
            boardService.save(member2.getLoginId(), addFormDto2, new UploadFile("1", "0f08909f-e55d-4214-8711-4ea3b23563b4.PNG"));


        }
    }


}
