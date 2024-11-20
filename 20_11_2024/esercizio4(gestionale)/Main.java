import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
Faccio inserire al max 3 valori. Ad ogni valore inserito calcolo la somma. Se è negativa stoppo il ciclo.
Alla fine mostro i valori inseriti e la loro somma.
 */

public class Main {

  public static void main(String[] args) {
    ArrayList<Calciatore> c1 = new ArrayList<>(Arrays.asList(
      new Calciatore("n1", "r1"),
      new Calciatore("n2", "r2"),
      new Calciatore("n3", "r3"),
      new Calciatore("n4", "r4"),
      new Calciatore("n5", "r5"),
      new Calciatore("n6", "r6"),
      new Calciatore("n7", "r7"),
      new Calciatore("n8", "r8"),
      new Calciatore("n9", "r9"),
      new Calciatore("n10", "r10"),
      new Calciatore("n11", "r11"),
      new Calciatore("n12", "r12")
      )
    );

    ArrayList<Calciatore> c2 = new ArrayList<>(Arrays.asList(
      new Calciatore("n21", "r21"),
      new Calciatore("n22", "r22"),
      new Calciatore("n23", "r23"),
      new Calciatore("n24", "r24"),
      new Calciatore("n25", "r25"),
      new Calciatore("n26", "r26"),
      new Calciatore("n27", "r27"),
      new Calciatore("n28", "r28"),
      new Calciatore("n29", "r29"),
      new Calciatore("n210", "r210"),
      new Calciatore("n211", "r211"),
      new Calciatore("n212", "r212")
      )
    );
    Squadra sq1 = new Squadra("squdra1", c1);
    Squadra sq2 = new Squadra("squdra2", c2);

    Partita p1 = new Partita(sq1, sq2);

    p1.generaRisultato();

    p1.mostraSquadraVincitrice();
 }
}