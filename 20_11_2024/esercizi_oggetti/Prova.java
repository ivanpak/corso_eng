import java.util.ArrayList;
import java.util.Scanner;

/*
Faccio inserire al max 3 valori. Ad ogni valore inserito calcolo la somma. Se è negativa stoppo il ciclo.
Alla fine mostro i valori inseriti e la loro somma.
 */

public class Prova {
    int x; 

  public Prova () {
    x = 5;  // Set the initial value for the class attribute x
  }

  public static void main(String[] args) {
    Prova myObj = new Prova (); //  call the constructor
    System.out.println(myObj.x); // Print the value of x
 }
}