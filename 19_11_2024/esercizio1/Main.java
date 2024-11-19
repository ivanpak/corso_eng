import java.util.Scanner;

/*
Scrivi un programma che continua a chiedere all'utente di inserire un numero fino a quando l'utente inserisce un numero negativo. Durante ogni iterazione, controlla con un if se il numero è pari o dispari e stampalo.



Chiedi all'utente di inserire un numero.
Continua a chiedere il numero finché l'utente non inserisce un numero negativo.
Usa if per verificare se il numero è pari o dispari.
Stampa il risultato.
 */

public class Main {
    public static void main(String[] args) {

        // Inizializzazione scanner
        Scanner scanner1 = new Scanner(System.in);
        
        
        // beginning serve per evitare di mostrare pari/dispari al primo ciclo
        boolean beginning = true;
        int i1 = 1;

        // Ciclo di input
        while(i1>=0) {
            // eseguo questo codice solo dal secondo ciclo
            if(!beginning) {
                // verifica pari/dispari
                String p;
                if(i1%2 == 0) {
                    p = "pari";
                } else {
                    p = "dispari";
                }
                // String p = (i1%2==0) ? "pari" : "dispari";
                System.out.println("il numero \u00E8 " + p);
            } else {
                beginning = false;
            }

            // inserimento numero
            System.out.println("---------------");
            System.out.println("inserisci numero");
            i1 = scanner1.nextInt();
        }
    }
}