import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

  public static void main(String[] args) {
    // Genero una biblioteca vuota
    Biblioteca b = new Biblioteca();

    // Inizializzo gli scanner
    Scanner stringScanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);

    // Creo l'interfaccia per la biblioteca
    InterfacciaBiblioteca biblioInterfaccia = new InterfacciaBiblioteca(b, stringScanner, intScanner);
    
    // Loop del menu. Vi rimango finche la funzione non ritorna false
    boolean res1;
    do {
      res1 = biblioInterfaccia.eseguiOperazione();
    } while(res1);

    // chiudo gli scanner
    stringScanner.close();
    intScanner.close();
 }
}