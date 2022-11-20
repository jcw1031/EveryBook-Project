package jcw.javaTeamProjectServer.controller;

import jcw.javaTeamProjectServer.entity.Book;
import jcw.javaTeamProjectServer.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/list/{memberId}")
    public List<Book> bookList(@PathVariable("memberId") Long memberId) {
        return bookService.findByMemberId(memberId);
    }

    @PostMapping("")
    public void booking(@RequestBody Book book) {
        Book save = bookService.booking(book);
        log.info("Book = {}", save);
    }
}
