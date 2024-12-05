package com.ivanpak.bookproj.book.service;

import com.ivanpak.bookproj.book.dto.BookDTO;
import com.ivanpak.bookproj.book.exception.NoDataFoundException;
import com.ivanpak.bookproj.book.model.Book;
import com.ivanpak.bookproj.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookServiceI {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public BookDTO findByUuid(String uuid) {
        BookDTO b1 = modelToDto(bookRepository.findByUuid(uuid).orElseThrow(NoDataFoundException::new));
        b1.setAvgStars(
                webClientBuilder.build().get()
                         // .uri("http://localhost:8081/api/v1/reviews/avg",
                        .uri("http://review-service/api/v1/reviews/avg",
                                uriBuilder -> uriBuilder.queryParam("bookUuid", uuid).build())
                        .retrieve()
                        .bodyToMono(Double.class)
                        .block()

        );
        return b1;
    }

    public List<BookDTO> findAll() {

        return bookRepository.findAll()
                .stream()
                .map(BookServiceImpl::modelToDto)
                .toList();
    }

    public BookDTO save(BookDTO c) {
        c.setUuid(String.valueOf(UUID.randomUUID()));
        return modelToDto(bookRepository.save(dtoToModel(c)));
    }

    public BookDTO update(String uuid, BookDTO newBook) {
        Book old = bookRepository.findByUuid(uuid).orElseThrow(RuntimeException::new);
        old.setTitle(newBook.getTitle());
        return modelToDto(bookRepository.save(old));
    }

    public List<BookDTO> findByNome(String nome) {

        return bookRepository.findByTitle(nome)
                .stream()
                .map(BookServiceImpl::modelToDto)
                .toList();
    }

    @Transactional
    public void delete(String uuid) {
        bookRepository.deleteByUuid(uuid);
    }




    private static Book dtoToModel(BookDTO book) {
        return Book.builder()
                .uuid(book.getUuid())
                .title(book.getTitle())
                .author(book.getAuthor())
                .build();
    }

    private static BookDTO modelToDto(Book book) {
        return BookDTO.builder()
                .uuid(book.getUuid())
                .title(book.getTitle())
                .author(book.getAuthor())
                .build();
    }

}
