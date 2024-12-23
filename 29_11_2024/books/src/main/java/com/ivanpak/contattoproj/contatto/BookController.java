package com.ivanpak.contattoproj.contatto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class BookController{

    @Autowired
    private BookServiceI bookService;


    @GetMapping("/h1")
    public String listBook(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "home.jsp";
    }

    @GetMapping("/h2")
    public String listBook2(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "home2.jsp";
    }
}
