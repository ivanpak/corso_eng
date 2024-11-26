package com.ivanpak.contattoproj.contatto;

import java.util.List;

public interface ContattoServiceI {

    public List<Contatto> getAllContatti();

    public Contatto addContatto(Contatto c);

    public List<Contatto> findByNome(String nome);

    public List<Contatto> findByNumTel(String numtel);
}
