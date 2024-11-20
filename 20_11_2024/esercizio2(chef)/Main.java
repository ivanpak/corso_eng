import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
Faccio inserire al max 3 valori. Ad ogni valore inserito calcolo la somma. Se è negativa stoppo il ciclo.
Alla fine mostro i valori inseriti e la loro somma.
 */

public class Main {

  public static void main(String[] args) {
    Chef c = new Chef("Paolo", "veneto", new ArrayList<>(Arrays.asList("Pasta", "Manzo", "Pomodoro")));
    System.out.println("Chef: " + c.nome + " tipo: " + c.tipo);
    ArrayList<String> piatto = c.creaPiatto();
    System.out.println("Ricetta: " + piatto.toString());
 }
}