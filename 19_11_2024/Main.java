import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
Faccio inserire al max 3 valori. Ad ogni valore inserito calcolo la somma. Se è negativa stoppo il ciclo.
Alla fine mostro i valori inseriti e la loro somma.
 */

public class Main {
    public static void main(String[] args) {

        int i = 0;
        int a = i++;
        System.out.println(i);
        System.out.println(a);

        ArrayList<String> l1 = new ArrayList<>();
        l1.add("ciaone");
        l1.add("ok");
        l1.add("bene");

        l1.remove(1);

        System.out.println(l1);

        System.out.println();


        Integer arr[] = { 1 , 2 , 3 , 4 , 5 , 6 };  
        System.out.println( "Array:" +Arrays.toString(arr));  
        ArrayList<Integer> arrayList =  new  ArrayList<Integer>(Arrays.asList(arr));  
        arrayList .add( 7 );  
        arr = arrayList .toArray(arr);  
        System.out.println( "Array dopo aggiunta: " +Arrays.toString(arr)); 

    }
}