package com.ivanpak.bookproj.book.controller;

import com.ivanpak.bookproj.book.groups.Step1;
import com.ivanpak.bookproj.book.service.BookServiceI;
import com.ivanpak.bookproj.book.dto.BookDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/books")
@RestController
public class BookController {

    @Autowired
    private BookServiceI bookService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<BookDTO> findAll() {
        return bookService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{uuid}")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "tutto ok"),
            @ApiResponse(responseCode = "404", description = "l'uuid indicato non esiste sulla base dati"),
    })
    @Operation(summary = "endpoint per ottenre un book by uuid", description="endpoint per ottenere un singolo book con l'uuid specificato")
    public BookDTO findByUuid(@PathVariable String uuid) {
        return bookService.findByUuid(uuid);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping()
    public BookDTO save(@RequestBody @Validated(Step1.class) BookDTO c) {
        return bookService.save(c);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{uuid}")
    public BookDTO update(@PathVariable("uuid") String uuid, @RequestBody BookDTO c) {
        return bookService.update(uuid, c);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/nome/{nome}")
    public List<BookDTO> findByNome(@PathVariable("nome") String nome) {
        return bookService.findByNome(nome);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable("uuid") String uuid) {
        bookService.delete(uuid);
    }
}
