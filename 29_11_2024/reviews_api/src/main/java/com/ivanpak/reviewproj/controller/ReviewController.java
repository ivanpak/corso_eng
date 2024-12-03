package com.ivanpak.reviewproj.controller;

import com.ivanpak.reviewproj.dto.ReviewDTO;
import com.ivanpak.reviewproj.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<ReviewDTO> findAll() {
        return reviewService.findAll();
    }
    @GetMapping("/{uuid}")
    public List<ReviewDTO> findByBookUuid(@PathVariable("uuid") String bookUuid) {
        return reviewService.findByBookUuid(bookUuid);
    }
    @PostMapping
    public ReviewDTO save(@RequestBody ReviewDTO r) {
        return reviewService.save(r);
    }
    @PutMapping("/{uuid}")
    public ReviewDTO update(@PathVariable("uuid") String uuid,@RequestBody ReviewDTO r) {
        return reviewService.update(uuid, r);
    }
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable("uuid") String uuid) {
        reviewService.delete(uuid);
    }

    @GetMapping("/avg/{bookUuid}")
    public Double getAverageScore(@PathVariable("bookUuid") String bookUuid) {
        return reviewService.getAvgScore(bookUuid);
    }
}
