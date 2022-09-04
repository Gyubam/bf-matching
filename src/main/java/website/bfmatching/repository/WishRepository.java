package website.bfmatching.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import website.bfmatching.entity.Wish;

public interface WishRepository extends JpaRepository<Wish, Long> {

}
