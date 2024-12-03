package com.ivanpak.reviewproj.service;

import com.ivanpak.reviewproj.dto.ReviewDTO;
import com.ivanpak.reviewproj.model.Review;
import com.ivanpak.reviewproj.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<ReviewDTO> findAll() {
        return reviewRepository.findAll()
                .stream()
                .map(r -> ReviewServiceImpl.modelToDTO(r))
                .toList();
    }

    @Override
    public List<ReviewDTO> findByBookUuid(String bookUuid) {
        return reviewRepository.findByBookUuid(bookUuid)
                .stream()
                .map(r -> ReviewServiceImpl.modelToDTO(r))
                .toList();
    }

    @Override
    public ReviewDTO save(ReviewDTO r) {
        Review r2 = dtoToModel(r);
        r2.setUuid(String.valueOf(UUID.randomUUID()));
        return modelToDTO(reviewRepository.save(r2));
    }

    @Override
    public ReviewDTO update(String uuid, ReviewDTO r) {
        Review rOld = reviewRepository.findByUuid(uuid).orElseThrow(RuntimeException::new);
        rOld.setBookUuid(r.getBookUuid());
        rOld.setStars(r.getStars());
        return modelToDTO(reviewRepository.save(rOld));
    }

    @Override
    public void delete(String uuid) {
        reviewRepository.deleteByUuid(uuid);
    }

    @Override
    public Double getAvgScore(String bookUuid) {
        return reviewRepository.findByBookUuid(bookUuid)
                .stream()
                .map(r -> r.getStars())
                .mapToDouble(n -> (double)n)
                .average()
                .orElse(0D);
    }




    private static Review dtoToModel(ReviewDTO reviewDTO) {
        return Review.builder()
                .uuid(reviewDTO.getUuid())
                .bookUuid(reviewDTO.getBookUuid())
                .stars(reviewDTO.getStars())
                .build();
    }

    private static ReviewDTO modelToDTO(Review review) {
        return ReviewDTO.builder()
                .uuid(review.getUuid())
                .bookUuid(review.getBookUuid())
                .stars(review.getStars())
                .build();
    }
}
