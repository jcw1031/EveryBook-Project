package jcw.javaTeamProjectServer.controller;

import jcw.javaTeamProjectServer.dto.ReviewListDTO;
import jcw.javaTeamProjectServer.entity.Review;
import jcw.javaTeamProjectServer.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("")
    public void writeReview(@RequestBody final Review review) {
        reviewService.write(review);
    }

    @GetMapping("/item/{item}")
    public List<ReviewListDTO> reviewByItem(@PathVariable("item") final Long itemKey) {
        return reviewService.reviewListByItem(itemKey);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable("id") final Long id) {
        reviewService.delete(id);
    }
}
