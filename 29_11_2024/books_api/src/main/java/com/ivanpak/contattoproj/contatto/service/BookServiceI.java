package com.ivanpak.contattoproj.contatto.service;

import com.ivanpak.contattoproj.contatto.dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookServiceI {

    public BookDTO findByUuid(String uuid);

    public List<BookDTO> findAll();

    public BookDTO save(BookDTO c);

    public BookDTO update(String uuid, BookDTO newBook);

    public List<BookDTO> findByNome(String nome);
}
