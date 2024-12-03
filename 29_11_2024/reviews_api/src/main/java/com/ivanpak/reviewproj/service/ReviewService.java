package com.ivanpak.reviewproj.service;

import com.ivanpak.reviewproj.dto.ReviewDTO;
import com.ivanpak.reviewproj.model.Review;

import java.util.List;

public interface ReviewService {
    public List<ReviewDTO> findAll();
    public List<ReviewDTO> findByBookUuid(String bookUuid);
    public ReviewDTO save(ReviewDTO r);
    public ReviewDTO update(String uuid, ReviewDTO r);
    public void delete(String uuid);
    public Double getAvgScore(String bookUuid);
}
