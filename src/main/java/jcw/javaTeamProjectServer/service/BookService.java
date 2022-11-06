package jcw.javaTeamProjectServer.service;

import jcw.javaTeamProjectServer.entity.Book;
import jcw.javaTeamProjectServer.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> findByMemberId(Long memberId) {
        return bookRepository.findByMemberKey(memberId);
    }

    public Book booking(Book book) {
        return bookRepository.save(book);
    }
}
