package com.ivanpak.contattoproj.contatto.repository;

import com.ivanpak.contattoproj.contatto.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    public List<Book> findByNome(String name);

    public Optional<Book> findByUuid(String uuid);
}
