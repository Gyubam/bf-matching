package website.bfmatching.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.bfmatching.Dto.AddFormDto;
import website.bfmatching.entity.Board;
import website.bfmatching.entity.Member;
import website.bfmatching.file.UploadFile;
import website.bfmatching.repository.BoardRepository;
import website.bfmatching.repository.MemberRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    private final EntityManager entityManager;

    @Transactional
    public Long save(String loginId, AddFormDto addFormDto, UploadFile file) {

        Member findMember = memberRepository.findByLoginId(loginId);

        String projectName = addFormDto.getProjectName();
        String projectIntro = addFormDto.getProjectIntro();
        String writerName = addFormDto.getWriterName();
        String r_title1 = addFormDto.getR_title1();
        String r_title2 = addFormDto.getR_title2();
        String r_title3 = addFormDto.getR_title3();
        String r_content1 = addFormDto.getR_content1();
        String r_content2 = addFormDto.getR_content2();
        String r_content3 = addFormDto.getR_content3();

        String needPosition = addFormDto.getNeedPosition();

        String uploadFileName = file.getUploadFileName(); // 사용자가 업로드한 파일명
        String storeFileName = file.getStoreFileName(); // 서버 내부 관리 파일명


        Board board = new Board(findMember, writerName, projectName, projectIntro, r_title1, r_title2,
                r_title3, r_content1, r_content2, r_content3, uploadFileName, storeFileName, needPosition);

        boardRepository.save(board);

        return board.getId();
    }

    @Transactional
    public void editPost(Long boardId, AddFormDto addFormDto){

        Optional<Board> board = boardRepository.findById(boardId);

        if (board.isPresent()){

            Board boardData = board.get();

            boardData.editBoard(addFormDto.getWriterName(), addFormDto.getProjectName(),
                    addFormDto.getProjectIntro(), addFormDto.getR_title1(), addFormDto.getR_title2(),
                    addFormDto.getR_title3(), addFormDto.getR_content1(), addFormDto.getR_content2(),
                    addFormDto.getR_content3(), addFormDto.getNeedPosition());

        }

//        entityManager.flush();
//        entityManager.clear();


    }


}
