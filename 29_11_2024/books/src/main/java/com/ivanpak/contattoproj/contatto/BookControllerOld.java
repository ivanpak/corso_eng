/*package com.ivanpak.contattoproj.contatto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/books")
@RestController
public class BookControllerOld {

    @Autowired
    private BookServiceI bookService;

    @GetMapping()
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping()
    public Book addBook(@RequestBody Book c) {
        return bookService.addBook(c);
    }

    @GetMapping("/nome/{nome}")
    public List<Book> getByNome(@PathVariable("nome") String nome) {
        return bookService.findByNome(nome);
    }
}
*/