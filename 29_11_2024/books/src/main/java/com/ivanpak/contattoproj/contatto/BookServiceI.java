package com.ivanpak.contattoproj.contatto;

import java.util.List;

public interface BookServiceI {

    public List<Book> getAllBooks();

    public Book addBook(Book c);

    public List<Book> findByNome(String nome);
}
