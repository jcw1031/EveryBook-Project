package jcw.javaTeamProjectServer.service;

import jcw.javaTeamProjectServer.entity.Book;
import jcw.javaTeamProjectServer.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book booking(final Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findByMemberId(final Long memberId) {
        return bookRepository.findByMemberKey(memberId);
    }

    public void bookDelete(final Long bookKey) {
        Optional<Book> optionalBook = bookRepository.findById(bookKey);
        bookRepository.delete(optionalBook.get());
    }

}
