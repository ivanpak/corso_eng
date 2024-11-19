import java.util.Arrays;
import java.util.Scanner;

/*
Scrivi un programma che calcoli e stampi il giorno della settimana corrispondente a numeri da 1 a 7. Usa un ciclo for e un switch per abbinare ogni numero al nome del giorno.



Usa un ciclo for per iterare dal numero 1 al numero 7.
Per ogni numero, usa un switch per determinare il giorno della settimana (ad esempio, 1 = Lunedì, 2 = Martedì, ecc.).
Stampa il giorno della settimana corrispondente.
 */

// Nota: ho usato alcuni caratteri rappresentati in codice unicode e.g. \u00EC.
// Questo perchè scrivendoli normalmente dava errore, credo perchè l'encoding usato nell'IDE e nell'output è diverso. Penso unicode e ascii respectively.

public class Main {
    public static void main(String[] args) {
        // int[] nums = {1,2,3};
        // int[] nums = new int[5];
        // System.out.println(Arrays.toString(nums));

        
        // Itero sui numeri da 1 a 7
        for (int i =1; i<=7 ; i++) {

            // Assegno il nome del giorno
            String nomeGiorno = "";
            switch (i) {
                case 1:
                    nomeGiorno = "Luned\u00EC";
                    break;
                case 2:
                    nomeGiorno = "Marted\u00EC";
                    break;
                case 3:
                    nomeGiorno = "Mercoled\u00EC";
                    break;
                case 4:
                    nomeGiorno = "Gioved\u00EC";
                    break;
                case 5:
                    nomeGiorno = "Venerd\u00EC";
                    break;
                case 6:
                    nomeGiorno = "Sabato";
                    break;
                case 7:
                    nomeGiorno = "Domenica";
                    break;
                default:
                    break;
            }

            // Costruisco la stringa di output
            String out1 = String.format("Il %d\u00B0 giorno della settimana \u00E8 %s", i, nomeGiorno);
            System.out.println(out1);
        } 
    }
}