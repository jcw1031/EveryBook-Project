package jcw.javaTeamProjectServer.service;

import jcw.javaTeamProjectServer.entity.Review;
import jcw.javaTeamProjectServer.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public void write(Review review) {
        review.setReviewDate(LocalDate.now().toString());
        reviewRepository.save(review);
    }

    public List<Review> reviewListByItem(Long itemKey) {
        return reviewRepository.findByItemKey(itemKey);
    }
}
