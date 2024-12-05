package com.ivanpak.bookproj.book.service;

import com.ivanpak.bookproj.book.dto.BookDTO;

import java.util.List;

public interface BookServiceI {

    public BookDTO findByUuid(String uuid);

    public List<BookDTO> findAll();

    public BookDTO save(BookDTO c);

    public BookDTO update(String uuid, BookDTO newBook);

    public List<BookDTO> findByNome(String nome);

    public void delete(String uuid);
}
