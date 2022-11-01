package jcw.javaTeamProjectServer.repository;

import jcw.javaTeamProjectServer.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
