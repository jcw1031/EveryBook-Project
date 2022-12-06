package jcw.javaTeamProjectServer.service;

import jcw.javaTeamProjectServer.dto.PointDTO;
import jcw.javaTeamProjectServer.entity.Book;
import jcw.javaTeamProjectServer.entity.Item;
import jcw.javaTeamProjectServer.entity.Member;
import jcw.javaTeamProjectServer.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final MemberService memberService;
    private final ItemService itemService;
    private final BookRepository bookRepository;

    public Book booking(final Book book) {
        Optional<Member> optionalMember = memberService.findById(book.getMemberKey());
        Optional<Item> optionalItem = itemService.findById(book.getItemKey());

        if (optionalMember.isPresent() && optionalItem.isPresent()) {
            PointDTO pointDto = PointDTO.builder()
                    .memberKey(book.getMemberKey())
                    .point((int) (book.getBookPrice() * 0.95))
                    .build();

            pointDto.reducePoint();
            memberService.updatePoint(pointDto);

            return bookRepository.save(book);
        } else {
            throw new IllegalArgumentException("Booking Fail");
        }
    }

    public List<Book> findByMemberId(final Long memberId) {
        return bookRepository.findByMemberKey(memberId);
    }

    public void bookDelete(final Long bookKey) {
        Optional<Book> optionalBook = bookRepository.findById(bookKey);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            int bookPrice = book.getBookPrice();
            bookRepository.delete(book);

            PointDTO pointDto = PointDTO.builder()
                    .memberKey(book.getMemberKey())
                    .point((int) (bookPrice * 0.95))
                    .build();

            memberService.updatePoint(pointDto);
        }
    }
}
