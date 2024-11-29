package com.ivanpak.contattoproj.contatto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookServiceI {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book c) {
        return bookRepository.save(c);
    }

    public List<Book> findByNome(String nome) {
        return bookRepository.findByNome(nome);
    }
}
