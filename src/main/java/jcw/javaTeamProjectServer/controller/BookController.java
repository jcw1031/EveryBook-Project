package jcw.javaTeamProjectServer.controller;

import jcw.javaTeamProjectServer.entity.Book;
import jcw.javaTeamProjectServer.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/book")
@Slf4j
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("")
    public void booking(@RequestBody final Book book) {
        book.setBookDate(LocalDate.now().toString());
        Book save = bookService.booking(book);
        log.info("Book = {}", save);
    }

    @GetMapping("/list/{id}")
    public List<Book> bookList(@PathVariable("id") final Long memberKey) {
        return bookService.findByMemberId(memberKey);
    }

    @DeleteMapping("/{id}")
    public void bookCancel(@PathVariable("id") final Long bookKey) {
        bookService.bookDelete(bookKey);
    }

}
