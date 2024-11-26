package com.ivanpak.contattoproj.contatto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContattoServiceImpl implements ContattoServiceI{

    @Autowired
    private ContattoRepository contattoRepository;

    public List<Contatto> getAllContatti() {
        return contattoRepository.findAll();
    }

    public Contatto addContatto(Contatto c) {
        return contattoRepository.save(c);
    }
}
