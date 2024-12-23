import java.util.ArrayList;
import java.util.Scanner;

// Classe che gestisce una lista di libri. Permette di inserire, cercare e visualizzarli tutti
public class Biblioteca {
  ArrayList<Libro> libri;

  public Biblioteca () {
    this.libri = new ArrayList<>();
  }

  public void inserisci(String nome, int pagg) {
    Libro l1 = new Libro(nome, pagg);
    this.libri.add(l1);
  }

  public void stampa() {
    for (Libro l : libri) {
      l.stampa();
    }
  }

  public Libro cercaPerAutore(String autore) {
    for(Libro l: libri) {
      if(l.nomeAutore.equals(autore)) {
        return l;
      }
    }
    return null;
  }

  public Libro cercaPerNumPagine(int pagg) {
    for(Libro l: libri) {
      if(l.numeroPagine <= pagg) {
        return l;
      }
    }
    return null;
  }

}