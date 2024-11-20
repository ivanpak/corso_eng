import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
Faccio inserire al max 3 valori. Ad ogni valore inserito calcolo la somma. Se è negativa stoppo il ciclo.
Alla fine mostro i valori inseriti e la loro somma.
 */

public class Main {

  public static void main(String[] args) {
    Biblioteca b = new Biblioteca();

    Scanner stringScanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);

    InterfacciaBiblioteca biblioInterfaccia = new InterfacciaBiblioteca(b, stringScanner, intScanner);
    
    // Loop del menu
    boolean res1;
    do {
      res1 = biblioInterfaccia.eseguiOperazione();
    } while(res1);

    stringScanner.close();
    intScanner.close();
 }
}