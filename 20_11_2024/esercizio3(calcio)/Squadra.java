import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
Faccio inserire al max 3 valori. Ad ogni valore inserito calcolo la somma. Se è negativa stoppo il ciclo.
Alla fine mostro i valori inseriti e la loro somma.
 */

public class Squadra {
  public String nome = "";
  public ArrayList<Calciatore> calciatori = new ArrayList<>();

  public Squadra(String nome, ArrayList<Calciatore> calciatori) {
    this.nome = nome;
    if(calciatori.size()!=12) {
      throw new java.lang.RuntimeException("La squadra deve contenere esattamente 12 giocatori");
    }
    if(verificaSquadra(calciatori)) {
      this.calciatori = calciatori;
      System.out.println("Suadra salvata correttamente");
    } else {
      System.out.println("La squadra contiene dei duplicati quindi non puo essere salvata");
      throw new java.lang.RuntimeException("La squadra contiene dei duplicati quindi non puo essere salvata");
    }
  }

  public boolean verificaSquadra(ArrayList<Calciatore> c) {
    for (int i=0; i<c.size(); i++) {
      for (int j=i+1; j<c.size(); j++) {
        if(duplicato(c.get(i), c.get(j))) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean duplicato(Calciatore c1, Calciatore c2) {
    if(c1.nome.equals(c2.nome) || c1.ruolo.equals(c2.ruolo)) {
      return true;
    } else {
      return false;
    }

  }

}