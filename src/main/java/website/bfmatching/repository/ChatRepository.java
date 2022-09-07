package website.bfmatching.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import website.bfmatching.entity.Chat;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    @Override
    @Query("select c from Chat c order by c.id")
    List<Chat> findAll();

    List<Chat> findByRoomIdOrderById(String roomId);
}
