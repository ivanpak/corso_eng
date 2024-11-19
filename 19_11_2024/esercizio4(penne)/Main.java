import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*Una ditta di spedizioni vuole gestire le spedizioni di penne. 

Ogni spedizione contiene una certa quantità di penne di diversi colori.

La ditta ha bisogno di un sistema che consenta di:



TASK ESPLORATIVA: Far generare autonomamente il tipo e il numero di penne
venduto al giorno e gestire anche il timing.



Aggiungere una spedizione: Ogni spedizione è composta da una riga di dati
che contiene la quantità di penne per ogni colore. I colori disponibili sono
Rosso, Blu, Verde, Nero.
Visualizzare tutte le spedizioni: Mostrare la quantità di penne per ciascun
colore in ogni spedizione.
Calcolare il totale di penne di ogni colore: Il sistema deve poter calcolare
quanti penne di ogni colore sono stati spediti in totale.
Ricerca per colore: Cercare una spedizione che abbia almeno una penna di
un determinato colore.


E necessario usare minimo cicli, condizioni, metodi e ArrayList o matrici per
implementare il sistema. */

/*
 * Responsabilità:
 * 
 * aggiunta spedizione
 * visualizzazione spedizioni
 * calcolo totale
 * ricerca per colore
 * 
 * 
 */

public class Main {
    
    static final String[] types = new String [] {"rosso", "blu", "verde", "nero"};
    static Scanner stringScanner = new Scanner(System.in);
    static Scanner intScanner = new Scanner(System.in);

    public static void main(String[] args) {

        // lunghezza massima visualizzazione nome
        int stringCutLength = 4;

        // Liste prenotazioni
        ArrayList<ArrayList<Integer>> spedizioni = new ArrayList<>();
        generaSpedizioni(spedizioni);

        // Inizializzazione scanner
        stringScanner = new Scanner(System.in);
        intScanner = new Scanner(System.in);
        

        // Loop del menu
        loop1: while(true) {
            System.out.println("\n------------MENU----------------");
            System.out.println("Inserisci stringa: inserisci, visualizza, report, cerca o chiudi?");
            String selector = stringScanner.nextLine();
            
            // seleziona l'operazione da eseguire
            switch (selector) {


                // inscerisci spedizione
                case "inserisci":
                    Main.inserimentoSpedizione(spedizioni);
                    break;
                

                // cerca una spedizione
                case "cerca":
                    Main.cercaSpedizione(spedizioni);
                    break;


                // visualizza tutte le spedizioni
                case "visualizza":
                    Main.visualizzaSpedizioni(spedizioni);
                    break;


                // mostra la somma delle spedizioni
                case "report":
                    Main.sommaSpedizioni(spedizioni);
                    break;
                

                // esci dal menu
                case "chiudi":
                    System.out.println("arrivederci");
                    break loop1;
                
                default:
                    System.out.println("comando non supportato");
                    break;
            }
        }

        Main.stringScanner.close();
        Main.intScanner.close();
    }

    public static void inserimentoSpedizione(ArrayList<ArrayList<Integer>> speds) {

        // inserimento quantità
        System.out.println("----");
        System.out.println("inerisci rosse");
        Integer rosse = Main.intScanner.nextInt();
        System.out.println("inerisci blu");
        Integer blu = Main.intScanner.nextInt();
        System.out.println("inerisci verde");
        Integer verde = Main.intScanner.nextInt();
        System.out.println("inerisci nero");
        Integer nero = Main.intScanner.nextInt();

        // costruzione nuova spedizione
        ArrayList<Integer> newSped = new ArrayList<>(Arrays.asList(rosse, blu, verde, nero));
        // inserimento spedizione
        speds.add(newSped);

        System.out.println("spedizione inserita");
    }

    public static void visualizzaSpedizioni(ArrayList<ArrayList<Integer>> speds) {

        // stampa dell'intestazione della tabella
        for (String s : Main.types) {
            System.out.print(s + "\t");
        }
        System.out.print("\n");
        // stampa di ogni spedizione
        for (ArrayList<Integer> sped : speds) {
            for (Integer i : sped) {
                System.out.print(i + "\t");
            }
            System.out.print("\n");
        }
    }

    public static void sommaSpedizioni(ArrayList<ArrayList<Integer>> speds) {

        // somma per ogni colore e totale
        int[] sums = new int[4];
        int fullsum = 0;
        for (ArrayList<Integer> sped : speds) {
            for (int i=0; i<4; i++) {
                sums[i] += sped.get(i);
                fullsum += sped.get(i);
            }
        }

        // stampa del totale e della somma per ogni colore
        System.out.println("Il totale delle penne spedite e " + fullsum + ", così ripartito:");
        for (int i=0; i<4; i++) {
            System.out.println(Main.types[i] + ": " + sums[i]);
        }
    }

    public static void cercaSpedizione(ArrayList<ArrayList<Integer>> speds) {

        // inserimento colore cercato
        System.out.println("----");
        System.out.println("inerisci colore");
        String color = Main.stringScanner.nextLine();

        // veifica validità colore
        if(!Arrays.asList(Main.types).contains(color)) {
            System.out.println("Colore non valido");
        }

        // ricerca della spedizione con almeno una penna del colore specificato
        int spedId = cercaPosizione(speds, color);
        if(spedId!=-1) {
            stampaSpedizione(speds.get(spedId));
        } else {
            System.out.println("Nessuna spedizione con almeno una penna di colore " + color);
        }
    }

    // questa funzione restituisce l'indice della prima spedizione con almeno una penna del colore specificato
    public static int cercaPosizione(ArrayList<ArrayList<Integer>> l1, String color) {
        int ind1 = -1;
        // trovo l'indice corrispondente al colore
        int colorIndex = Arrays.asList(Main.types).indexOf(color);

        // cerco la prima spedizione che corrisponde al criterio e poi mi fermo
        for(int i=0; i<l1.size(); i++) {
            if(l1.get(i).get(colorIndex) > 0) {
                ind1 = i;
                break;
            }
        }
        // nel caso non sia stata trovata spedizione adatta ritorno -1

        return ind1;
    }

    // questa funzione stampa una singola spedizione, ponendo i nomi dei colori prima di ogni quantità
    public static void stampaSpedizione(ArrayList<Integer> sped) {
        for (int i=0; i<Main.types.length; i++) {
            System.out.print(Main.types[i] + ": " + sped.get(i) + "\t\t");
        }
        System.out.print("\n");
    }

    public static void generaSpedizioni(ArrayList<ArrayList<Integer>> speds) {
        for(int i =0; i<10; i++) {
            ArrayList<Integer> sped1 = generaSpedizione();
            stampaSpedizione(sped1);
            speds.add(sped1);
        }
    }

    public static ArrayList<Integer> generaSpedizione() {
        int sum=0;
        ArrayList<Integer> sped = new ArrayList<>();
        Random rand = new Random();
        while(sum==0) {
            sped.clear();
            for (int i=0; i<Main.types.length; i++) {
                sped.add(rand.nextInt(100));
            }
            sum = 0;
            for (Integer s: sped) {
                sum += s;
            }
        }

        return sped;
    }


}

