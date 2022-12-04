package jcw.javaTeamProjectServer.service;

import jcw.javaTeamProjectServer.dto.PointDto;
import jcw.javaTeamProjectServer.entity.Book;
import jcw.javaTeamProjectServer.entity.Item;
import jcw.javaTeamProjectServer.repository.BookRepository;
import jcw.javaTeamProjectServer.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final MemberService memberService;
    private final BookRepository bookRepository;
    private final ItemRepository itemRepository;

    public Book booking(final Book book) {
        Optional<Item> optionalItem = itemRepository.findById(book.getItemKey());
        Item item;
        if (optionalItem.isPresent()) {
            item = optionalItem.get();
        } else {
            throw new IllegalArgumentException("존재하지 않는 상품입니다.");
        }

        PointDto pointDto = PointDto.builder()
                .memberKey(book.getMemberKey())
                .point((int) (item.getItemPrice() * 0.05))
                .build();

        memberService.updatePoint(pointDto);

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
