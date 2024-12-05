package com.ivanpak.reviewproj.repository;

import com.ivanpak.reviewproj.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    public Optional<Review> findByUuid(String bookUuid);
    public List<Review> findByBookUuid(String bookUuid);
    public Long deleteByUuid(String uuid);

}
