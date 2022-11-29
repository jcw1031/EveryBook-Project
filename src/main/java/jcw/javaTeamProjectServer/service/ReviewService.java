package jcw.javaTeamProjectServer.service;

import jcw.javaTeamProjectServer.dto.UpdateAvgRatingDto;
import jcw.javaTeamProjectServer.entity.Item;
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
    private final ItemService itemService;

    /**
     * 리뷰 작성 (해당 item의 평균 리뷰 점수 업데이트)
     * @param review
     */
    public void write(Review review) {
        review.setReviewDate(LocalDate.now().toString());
        reviewRepository.save(review);
        UpdateAvgRatingDto avgRatingDto = new UpdateAvgRatingDto(review.getItemKey()
                , reviewRepository.avgRating(review.getItemKey()));
        itemService.updateAvgRating(avgRatingDto);
    }

    public List<Review> reviewListByItem(Long itemKey) {
        return reviewRepository.findByItemKey(itemKey);
    }

}
