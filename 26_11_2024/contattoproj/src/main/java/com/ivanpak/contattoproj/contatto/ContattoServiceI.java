package com.ivanpak.contattoproj.contatto;

import java.util.List;

public interface ContattoServiceI {

    public List<Contatto> getAllContatti();

    public Contatto addContatto(Contatto c);
}
