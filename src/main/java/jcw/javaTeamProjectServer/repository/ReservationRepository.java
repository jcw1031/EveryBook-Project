package jcw.javaTeamProjectServer.repository;

import jcw.javaTeamProjectServer.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Book, Long> {
}
