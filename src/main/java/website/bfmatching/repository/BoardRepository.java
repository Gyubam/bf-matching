package website.bfmatching.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import website.bfmatching.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {


}
