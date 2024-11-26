package com.ivanpak.contattoproj.contatto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContattoRepository extends JpaRepository<Contatto, Long> {

    public List<Contatto> findByNome(String name);

    public List<Contatto> findByNumTel(String name);
}
