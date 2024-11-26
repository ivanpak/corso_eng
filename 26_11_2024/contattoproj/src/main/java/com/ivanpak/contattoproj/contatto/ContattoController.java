package com.ivanpak.contattoproj.contatto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.Controller;

import java.util.List;

@RequestMapping("/api/contatti")
@RestController
public class ContattoController {

    @Autowired
    private ContattoServiceI contattoService;

    @GetMapping()
    public List<Contatto> getAllContatti() {
        return contattoService.getAllContatti();
    }

    @PostMapping()
    public Contatto addContatto(@RequestBody Contatto c) {
        return contattoService.addContatto(c);
    }
}
