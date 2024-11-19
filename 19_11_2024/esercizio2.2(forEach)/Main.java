import java.util.ArrayList;
import java.util.Scanner;

/*
Faccio inserire al max 3 valori. Ad ogni valore inserito calcolo la somma. Se è negativa stoppo il ciclo.
Alla fine mostro i valori inseriti e la loro somma.
 */

public class Main {
    public static void main(String[] args) {
        // Inizializzazione scanner
        Scanner scanner1 = new Scanner(System.in);

        // Definisco il massimo numero di input richiesti
        int maxNumeroInput = 3;

        // inizializzo il contenitore
        int[] valori = new int[maxNumeroInput];
        
        int i1 = 0;
        int sum = 0;
        int count =0;

        // Ciclo di input
        while(sum>=0 & count<maxNumeroInput) {

            // inserimento numero
            System.out.println("---------------");
            System.out.println("inserisci numero");
            i1 = scanner1.nextInt();
            valori[count] = i1;
            sum += i1;
            count+=1;
        }

        // Chiusura scanner
        scanner1.close();

        // Mostro risultati
        System.out.println("---------------");
        System.out.println("I numeri inseriti sono");
        // Per poter usare foreach, che lavora su tutti i valori di un array,
        // faccio prima una copia delle posizioni dell'array corrispondenti ai valori inseriti
        int[] reducedValori = new int[count];
        System.arraycopy(valori, 0, reducedValori, 0, count);

        // Mostro i numeri inseriti
        for(int v : reducedValori) {
            System.out.println(v);
        }

        // Mostro la somma
        System.out.println(String.format("La somma e %d", sum));

    }
}