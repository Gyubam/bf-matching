package website.bfmatching.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import website.bfmatching.Dto.AddFormDto;
import website.bfmatching.entity.Board;
import website.bfmatching.entity.Member;
import website.bfmatching.file.UploadFile;
import website.bfmatching.service.BoardService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class BoardRepositoryTest {

    @PersistenceContext
    EntityManager em;
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    BoardService boardService;

    @Test
    public void boardTest() {

        Optional<Board> byId = boardRepository.findById(3L);

        System.out.println("byId = " + byId.get());
    }


}