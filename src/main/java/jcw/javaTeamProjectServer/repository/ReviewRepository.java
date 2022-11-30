package jcw.javaTeamProjectServer.repository;

import jcw.javaTeamProjectServer.dto.ReviewListDto;
import jcw.javaTeamProjectServer.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT new jcw.javaTeamProjectServer.dto.ReviewListDto" +
            "(r.reviewKey, r.reviewBody, r.reviewStar, r.reviewDate, m.memberName, r.memberKey) " +
            "FROM Review r, Member m " +
            "WHERE r.memberKey = m.memberKey AND r.itemKey = :itemKey")
    List<ReviewListDto> findByItemKey(@Param("itemKey") Long itemKey);

    @Query(value = "SELECT NULLIF(AVG(r.reviewStar), 0.0) FROM Review r WHERE r.itemKey = :itemKey GROUP BY r.itemKey")
    Double avgRating(@Param("itemKey") Long itemKey);
}
