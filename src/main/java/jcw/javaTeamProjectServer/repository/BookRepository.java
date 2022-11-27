package jcw.javaTeamProjectServer.repository;

import jcw.javaTeamProjectServer.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    public List<Book> findByMemberKey(Long memberId);

}
