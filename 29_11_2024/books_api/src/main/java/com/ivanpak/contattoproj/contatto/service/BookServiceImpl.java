package com.ivanpak.contattoproj.contatto.service;

import com.ivanpak.contattoproj.contatto.dto.BookDTO;
import com.ivanpak.contattoproj.contatto.model.Book;
import com.ivanpak.contattoproj.contatto.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookServiceI {

    @Autowired
    private BookRepository bookRepository;

    public BookDTO findByUuid(String uuid) {
        return modelToDto(bookRepository.findByUuid(uuid).orElseThrow(RuntimeException::new));
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
        old.setNome(newBook.getNome());
        return modelToDto(bookRepository.save(old));
    }

    public List<BookDTO> findByNome(String nome) {

        return bookRepository.findByNome(nome)
                .stream()
                .map(BookServiceImpl::modelToDto)
                .toList();
    }




    private static Book dtoToModel(BookDTO book) {
        return Book.builder()
                .uuid(book.getUuid())
                .nome(book.getNome())
                .build();
    }

    private static BookDTO modelToDto(Book book) {
        return BookDTO.builder()
                .uuid(book.getUuid())
                .nome((book.getNome()))
                .build();
    }
}
