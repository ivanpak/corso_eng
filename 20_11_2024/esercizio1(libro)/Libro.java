import java.util.ArrayList;
import java.util.Scanner;

/*
Faccio inserire al max 3 valori. Ad ogni valore inserito calcolo la somma. Se è negativa stoppo il ciclo.
Alla fine mostro i valori inseriti e la loro somma.
 */

public class Libro {
  String nomeAutore;
  int numeroPagine;

  public Libro () {
    this.nomeAutore = "";
    this.numeroPagine = 0;
  }

  public Libro (String nome, int pagg) {
    this.nomeAutore = nome;
    this.numeroPagine = pagg;
  }

  public void stampa() {
    System.out.println(String.format("Nome: %s Pagine: %s", this.nomeAutore, this.numeroPagine));
  }
}