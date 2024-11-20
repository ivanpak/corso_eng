import java.util.ArrayList;
import java.util.Scanner;


// Classe che rappresenta un libro
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