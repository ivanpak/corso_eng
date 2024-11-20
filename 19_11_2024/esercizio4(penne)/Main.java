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

public class Main {
    
    static final String[] types = new String [] {"rosso", "blu", "verde", "nero"};

    // metto gli scanner statici in modo tale da non avere uno scanner per ogni metodo, il che crea problemi perchè si rubano cose dal buffer di input
    static Scanner stringScanner;
    static Scanner intScanner;
    
    static int currentDayId = 0;

    static final int minShippingQuantity = 100;

    // Liste prenotazioni
    static ArrayList<ArrayList<Integer>> spedizioni = new ArrayList<>();
    static ArrayList<Integer> dayIds = new ArrayList<>(); // 1731970800
    static ArrayList<Boolean> sent = new ArrayList<>();

    public static void main(String[] args) {

        // Inizializzazione scanner
        stringScanner = new Scanner(System.in);
        intScanner = new Scanner(System.in);
        

        // Loop del menu
        loop1: while(true) {
            System.out.println("\n------------MENU----------------");
            System.out.println("Inserisci stringa: inserisci, genera, spedisci, visualizza, giorno, report, cerca, spedizioni o chiudi?");
            String selector = stringScanner.nextLine();
            
            // seleziona l'operazione da eseguire
            switch (selector) {

                case "inserisci":
                    Main.inserimentoSpedizione();
                    break;

                case "genera":
                    Main.generaSpedizioni();
                    break;

                case "spedisci":
                    Main.spedisci();
                    break;
                
                case "giorno":
                    Main.nuovoGiorno();
                    break;

                // cerca una spedizione
                case "cerca":
                    Main.cercaSpedizione();
                    break;

                // visualizza tutte le spedizioni
                case "visualizza":
                    Main.visualizzaSpedizioni();
                    break;


                // mostra la somma delle spedizioni
                case "report":
                    Main.sommaSpedizioniUser();
                    break;
                

                // esci dal menu
                case "chiudi":
                    System.out.println("arrivederci");
                    // qui nel break specifico che non voglio chiudere lo switch ma il loop del menu
                    break loop1;
                
                default:
                    System.out.println("comando non supportato");
                    break;
            }
        }

        Main.stringScanner.close();
        Main.intScanner.close();
    }


    // INTERFACCIA

    // funzione di interfaccia utente per inserire una spedizione
    public static void inserimentoSpedizione() {

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
        Main.spedizioni.add(newSped);
        Main.dayIds.add(Main.currentDayId);
        Main.sent.add(false);


        System.out.println("spedizione inserita");
    }

    // funzione di interfaccia utente per visualizzare le spedizioni
    public static void visualizzaSpedizioni() {

        // stampa dell'intestazione della tabella
        for (String s : Main.types) {
            System.out.print(s + "\t");
        }
        System.out.print("Day" + "\t");
        System.out.print("Sent" + "\t");
        System.out.print("\n");
        // stampa di ogni spedizione
        for (int i=0;i<Main.spedizioni.size(); i++) {
            ArrayList<Integer> sped = Main.spedizioni.get(i);
            Integer sday = Main.dayIds.get(i);
            Boolean sent1 = Main.sent.get(i);

            for (Integer j : sped) {
                System.out.print(j + "\t");
            }
            System.out.print(sday + "\t");

            System.out.print(sent1 + "\t");
            System.out.print("\n");
        }
    }

    // funzione di interfaccia utente per mostrare la somma delle quantità delle spedizioni
    public static void sommaSpedizioniUser() {

        // somma per ogni colore e totale
        int[] sums = new int[Main.types.length];
        int fullsum = 0;
        for (ArrayList<Integer> sped : Main.spedizioni) {
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

    // funzione di interfaccia utente per cercare una spedizione
    public static void cercaSpedizione() {

        // inserimento colore cercato
        System.out.println("----");
        System.out.println("inerisci colore");
        String color = Main.stringScanner.nextLine();

        // veifica validità colore
        if(!Arrays.asList(Main.types).contains(color)) {
            System.out.println("Colore non valido");
        }

        // ricerca della spedizione con almeno una penna del colore specificato
        int spedId = cercaPosizione(Main.spedizioni, color);
        if(spedId!=-1) {
            stampaSpedizione(spedId);
        } else {
            System.out.println("Nessuna spedizione con almeno una penna di colore " + color);
        }
    }


    // nuovo giorno
    public static void nuovoGiorno() {
        Main.currentDayId +=1;
    }

    // spedisci se possibile
    private static void spedisci() {
        // cerca ordini non spediti
        ArrayList<Integer> unsentIds = new ArrayList<>();
        for (int i=0; i<Main.spedizioni.size(); i++) {
            if(Main.sent.get(i).equals(false)) {
                unsentIds.add(i);
            }
        }

        // somma quantità di spedizioni non spedite
        ArrayList<Integer> sums = Main.sommaSpedizioni(unsentIds);
        boolean ok = true;
        for(int s : sums) {
            if(s<Main.minShippingQuantity) {
                ok = false;
                break;
            }
        }

        
        if(!ok) {
            // se pennse non sufficienti non spedisco
            System.out.println("Penne insufficienti per la spedizione");
            return;
        } else {
            // altrimenti spedisco
            for(int id1: unsentIds) {
                Main.sent.set(id1, true);
            }
            System.out.println("Penne spedite");
        }
    }



    // UTILITIES



    // restituisce l'indice della prima spedizione con almeno una penna del colore specificato
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
    public static void stampaSpedizione(int id1) {
        ArrayList<Integer> sped = Main.spedizioni.get(id1);
        for (int i=0; i<Main.types.length; i++) {
            System.out.print(Main.types[i] + ": " + sped.get(i) + "\t\t");
        }
        System.out.print("Giorno" + ": " + Main.dayIds.get(id1) + "\t\t");
        System.out.print("Spedito" + ": " + Main.sent.get(id1) + "\t\t");
        System.out.print("\n");
    }

    // genero le spedizioni
    public static void generaSpedizioni() {
        // genera 3 spedizioni
        for(int i =0; i<3; i++) {
            ArrayList<Integer> sped1 = generaSpedizione();
            Main.spedizioni.add(sped1);
            Main.dayIds.add(Main.currentDayId);
            Main.sent.add(false);
            stampaSpedizione(Main.spedizioni.size()-1);
        }
    }

    // genera e restituisci una singola spedizione
    public static ArrayList<Integer> generaSpedizione() {
        int sum=0;
        ArrayList<Integer> sped = new ArrayList<>();
        Random rand = new Random();
        // genero spedizioni in loop e restituisco solo quando ne ottengo una con almeno una penna in totale
        while(sum==0) {
            sped.clear();
            for (int i=0; i<Main.types.length; i++) {
                sped.add(rand.nextInt(50));
            }
            sum = 0;
            for (Integer s: sped) {
                sum += s;
            }
        }

        return sped;
    }


    // somma le spedizioni specificate
    public static ArrayList<Integer> sommaSpedizioni(ArrayList<Integer> ids) {
        int[] sums = new int[Main.types.length];
        int fullsum = 0;
        for (int id1 : ids) {
            ArrayList<Integer> sped = Main.spedizioni.get(id1);
            for (int i=0; i<4; i++) {
                sums[i] += sped.get(i);
                fullsum += sped.get(i);
            }
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i=0; i<4; i++) {
            ret.add(sums[i]);
        }
        ret.add(fullsum);
        return ret;
    }


}

