import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
Faccio inserire al max 3 valori. Ad ogni valore inserito calcolo la somma. Se è negativa stoppo il ciclo.
Alla fine mostro i valori inseriti e la loro somma.
 */

public class Calciatore {


  public String nome = "";
  public String ruolo = "";

  public Calciatore(String nome, String ruolo) {
    this.nome = nome;
    this.ruolo = ruolo;
  }

  public void stampa() {
    System.out.println(String.format("%s - %s;", this.nome, this.ruolo));
  }

}