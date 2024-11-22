import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


// mi sa che ho sbagliato l'esercizio.
// Io ho definito una classe Ristorante da cui Utente eredita
// Utente è astratto e viene implementato in Chef e Critico, che in particolare ne definiscono il metodo contribuisci
// Quindi in sostanza ho considerato Ristorante come una cosa separata dalle altre,
// e ho fatto ereditare Utente da Ristorante solo perchè era indicato nell'esercizio
public class Main {
    public static Scanner stringScanner;
    public static Scanner intScanner;
    public static Scanner floatScanner;


    
    public static void main(String[] args) {
        stringScanner = new Scanner(System.in);
        intScanner = new Scanner(System.in);
        floatScanner = new Scanner(System.in);

        Ristorante r1 = new Ristorante();
        ArrayList<Utente> utenti = new ArrayList<>(Arrays.asList(
            new Chef("ivan", "email1", "pass1", 10.5f),
            new Chef("gino", "email2", "pass2", 10.5f),
            new Critico("paolo", "email3", "pass3", 10.5f)
        ));

        utenti.get(0).getPiatti().add("ciaone");
        System.out.println(utenti.get(0).getPiatti().toString());

        Menu m1 = new Menu(r1, utenti);

        m1.menu();


        stringScanner.close();
        intScanner.close();
        floatScanner.close();
    }
    
}
