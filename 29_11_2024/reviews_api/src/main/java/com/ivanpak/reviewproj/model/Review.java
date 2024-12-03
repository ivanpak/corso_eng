package com.ivanpak.reviewproj.model;

import com.ivanpak.reviewproj.exceptions.ScoreOutOfRange;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String uuid;
    private String bookUuid;
    private Integer stars;

    public void setStars(Integer stars) {
        if(stars<1 || stars>5) {
            throw new ScoreOutOfRange();
        }
        this.stars = stars;
    }
}