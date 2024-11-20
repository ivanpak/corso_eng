import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// Classe che permette di interfacciare l'utente con il contenuto di una biblioteca
public class InterfacciaBiblioteca {

    public Biblioteca b;
    public Scanner stringScanner;
    public Scanner intScanner;

    public InterfacciaBiblioteca(Biblioteca b, Scanner stringScanner, Scanner intScanner) {
        this.b = b;
        this.stringScanner = stringScanner;
        this.intScanner = intScanner;
    }

    // mostra un menu e in base all'input dell'utente esegue un'operazione
    // ritorna sempre true a meno che l'utente non abbia espresso volontà di uscire dal menu
    public boolean eseguiOperazione() {
        System.out.println("\n------------MENU BIBLIOTECA----------------");
        System.out.println("Inserisci stringa: inserisci, visualizza, cerca o chiudi?");
        String selector = stringScanner.nextLine();
        
        // seleziona l'operazione da eseguire
        switch (selector) {
            case "inserisci":
                inserimento();
                return true;

            case "cerca":
                cerca();
                return true;

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

    // funzione di interfaccia utente per visualizzare il contenuto della biblioteca
    public void visualizza() {
        b.stampa();
    }

    // funzione di interfaccia utente per cercare un libro
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
