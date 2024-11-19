import java.util.Scanner;

/*
Scrivi un programma che calcoli e stampi il giorno della settimana corrispondente a numeri da 1 a 7. Usa un ciclo for e un switch per abbinare ogni numero al nome del giorno.



Usa un ciclo for per iterare dal numero 1 al numero 7.
Per ogni numero, usa un switch per determinare il giorno della settimana (ad esempio, 1 = Lunedì, 2 = Martedì, ecc.).
Stampa il giorno della settimana corrispondente.
 */

public class Main {
    public static void main(String[] args) {

        for (int i =1; i<=7 ; i++) {
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

            String out1 = String.format("Il %d\u00B0 giorno della settimana \u00E8 %s", i, nomeGiorno);
            System.out.println(out1);
        } 
    }
}