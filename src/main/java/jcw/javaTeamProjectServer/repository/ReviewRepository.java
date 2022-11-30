package jcw.javaTeamProjectServer.repository;

import jcw.javaTeamProjectServer.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByItemKey(Long itemKey);

    @Query(value = "SELECT AVG(r.reviewStar) FROM Review r WHERE r.itemKey = :itemKey GROUP BY r.itemKey")
    double avgRating(@Param("itemKey") Long itemKey);
}
