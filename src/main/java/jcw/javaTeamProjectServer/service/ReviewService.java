package jcw.javaTeamProjectServer.service;

import jcw.javaTeamProjectServer.dto.ReviewListDTO;
import jcw.javaTeamProjectServer.dto.UpdateAvgRatingDTO;
import jcw.javaTeamProjectServer.entity.Review;
import jcw.javaTeamProjectServer.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ItemService itemService;

    /**
     * 리뷰 작성 (해당 item의 평균 리뷰 점수 업데이트)
     * @param review
     */
    @Transactional
    public void write(final Review review) {
        review.setReviewDate(LocalDate.now().toString());
        reviewRepository.save(review);
        UpdateAvgRatingDTO avgRatingDto = new UpdateAvgRatingDTO(review.getItemKey()
                , reviewRepository.avgRating(review.getItemKey()));
        itemService.updateAvgRating(avgRatingDto);
    }

    public List<ReviewListDTO> reviewListByItem(Long itemKey) {
        return reviewRepository.findByItemKey(itemKey);
    }

    /**
     * 리뷰 삭제 (해당 item 평균 리뷰 점수 업데이트)
     * @param reviewKey
     */
    @Transactional
    public void delete(final Long reviewKey) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewKey);
        if (optionalReview.isPresent()) {
            Review review = optionalReview.get();
            Long itemKey = review.getItemKey();
            reviewRepository.delete(review);
            log.info("review 삭제 성공");
            UpdateAvgRatingDTO avgRatingDto = new UpdateAvgRatingDTO(itemKey
                    , reviewRepository.avgRating(itemKey));
            if (avgRatingDto.getAvgRating() == null) {
                avgRatingDto.setAvgRating(0.0);
            }
            itemService.updateAvgRating(avgRatingDto);
        } else {
            log.info("삭제 불가");
            throw new IllegalArgumentException("삭제 실패");
        }
    }
}
