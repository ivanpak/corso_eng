package com.ivanpak.contattoproj.contatto.controller;

import com.ivanpak.contattoproj.contatto.service.BookServiceI;
import com.ivanpak.contattoproj.contatto.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/books")
@RestController
public class BookController {

    @Autowired
    private BookServiceI bookService;

    @GetMapping()
    public List<BookDTO> findAll() {
        return bookService.findAll();
    }

    @PostMapping()
    public BookDTO save(@RequestBody BookDTO c) {
        return bookService.save(c);
    }

    @PutMapping("/{uuid}")
    public BookDTO update(@PathVariable("uuid") String uuid, @RequestBody BookDTO c) {
        return bookService.update(uuid, c);
    }

    @GetMapping("/nome/{nome}")
    public List<BookDTO> findByNome(@PathVariable("nome") String nome) {
        return bookService.findByNome(nome);
    }
}
