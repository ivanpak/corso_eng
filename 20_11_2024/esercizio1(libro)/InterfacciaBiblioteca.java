import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InterfacciaBiblioteca {

    public Biblioteca b;
    public Scanner stringScanner;
    public Scanner intScanner;

    public InterfacciaBiblioteca(Biblioteca b, Scanner stringScanner, Scanner intScanner) {
        this.b = b;
        this.stringScanner = stringScanner;
        this.intScanner = intScanner;
    }

    public boolean eseguiOperazione() {
        System.out.println("\n------------MENU BIBLIOTECA----------------");
        System.out.println("Inserisci stringa: inserisci, visualizza, cerca o chiudi?");
        String selector = stringScanner.nextLine();
        
        // seleziona l'operazione da eseguire
        switch (selector) {
            case "inserisci":
                inserimento();
                return true;

            // cerca una spedizione
            case "cerca":
                cerca();
                return true;

            // visualizza tutte le spedizioni
            case "visualizza":
                visualizza();
                return true;
            
            // esci dal menu
            case "chiudi":
                System.out.println("arrivederci");
                return false;
            
            default:
                System.out.println("comando non supportato");
                return true;
        }
 }

 public void inserimento() {

        // inserimento dati
        System.out.println("----");
        System.out.println("inerisci autore");
        String autore = stringScanner.nextLine();
        System.out.println("inerisci pagine");
        Integer pagine = intScanner.nextInt();

        b.inserisci(autore, pagine);
        System.out.println("libro inserito");
    }

    // funzione di interfaccia utente per visualizzare le spedizioni
    public void visualizza() {
        b.stampa();
    }

    // funzione di interfaccia utente per cercare una spedizione
    public void cerca() {

        // inserimento colore cercato
        System.out.println("----");
        System.out.println("come cercare: autore o pagine");
        String selector = stringScanner.nextLine();
        switch (selector) {
            case "autore":
                System.out.println("inserisci autore");
                String autore = stringScanner.nextLine();
                Libro l1 = b.cercaPerAutore(autore);
                if(l1!=null) {
                    l1.stampa();  
                } else {
                    System.out.println("Nessun libro con questi parametri");
                }
                break;
            
            case "pagine":
                System.out.println("inserisci pagine");
                int pagine = intScanner.nextInt();
                Libro l2 = b.cercaPerNumPagine(pagine);
                if(l2!=null) {
                    l2.stampa();  
                } else {
                    System.out.println("Nessun libro con questi parametri");
                }
                
                break;
        
            default:
                System.out.println("comando non supportato");
                break;
        }
    }
}
