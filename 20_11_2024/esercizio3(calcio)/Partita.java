import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
Faccio inserire al max 3 valori. Ad ogni valore inserito calcolo la somma. Se è negativa stoppo il ciclo.
Alla fine mostro i valori inseriti e la loro somma.
 */

public class Partita {
  public Squadra[] squadre = new Squadra[2];
  int risultato = -1; //-1,  0,1,2
  Random rand = new Random();

  public Partita(Squadra sq1, Squadra sq2) {
    squadre[0] = sq1;
    squadre[1] = sq2;
  }

  public void generaRisultato() {
    this.risultato = rand.nextInt(3);
  }

  public void mostraSquadraVincitrice() {
    if(risultato==-1) {
      System.out.println("Partita non disputata");
    } else if(risultato==2) {
      System.out.println("Partita finita in pareggio");
    } else {
      System.out.println(String.format("La squadra vincitrice nella partita %s vs %s e la %s", squadre[0].nome, squadre[1].nome, squadre[risultato].nome));
      System.out.println("La squadra e composta dai seguenti giocatori");
      for(Calciatore c: squadre[risultato].calciatori) {
        c.stampa();
      }
    }

  }

}