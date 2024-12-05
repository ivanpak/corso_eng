package com.ivanpak.bookproj.book.dto;

import com.ivanpak.bookproj.book.groups.Step1;
import com.ivanpak.bookproj.book.groups.Step2;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    @Null
    private String uuid;
    @NotNull(message="mettici un titolo", groups= Step1.class)
    @Size(min=5, max=50 , groups= Step1.class)
    private String title;
    @NotNull(message="mettici un autore", groups = Step2.class)
    @Size(min=5, max=50, groups = Step2.class)
    private String author;
    private Double avgStars;
}
