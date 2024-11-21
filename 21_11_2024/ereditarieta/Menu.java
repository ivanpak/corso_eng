import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner stringScanner;
    Scanner intScanner;
    Ristorante ristorante;
    ArrayList<Utente> utenti;

    public Menu(Ristorante r) {
        stringScanner = Main.stringScanner;
        intScanner = Main.intScanner;
        this.ristorante = r;
    }
    public Menu(Ristorante r, ArrayList<Utente> u) {
        stringScanner = Main.stringScanner;
        intScanner = Main.intScanner;
        this.ristorante = r;
        this.utenti = u;
    }

    public void menu() {
        loop1: while(true) {
            System.out.println();
            System.out.println("-------MENU------------");
            System.out.println("1 aggiungi utente");
            System.out.println("2 login utente");
            System.out.println("3 contribuisci");
            System.out.println("6 visualizza catalogo");
            System.out.println("7 visualizza utenti");
            System.out.println("-----------------------");
            String selezione = stringScanner.nextLine();
            switch (selezione) {
                case "1":
                aggiungiUtente();
                break;
            case "2":
                login();
                break;
            case "3":
                contribuisci();
                break;
            case "6":
                visualizzaCatalogo();
                break;
            case "7":
                visualizzaUtenti();
                break;
            default:
                break loop1;
            }


        }

        stringScanner.close();
        intScanner.close();
    }

    private void aggiungiUtente() {
        System.out.println("inserisci nome");
        String nome = stringScanner.nextLine();
        int id1 = v.nextId();
        v.registraUtente(new Utente(id1, nome, new ArrayList<>()));
    }

    private void gestisciUtente() {
        System.out.println("inserisci id");
        int id1 = intScanner.nextInt();

        Utente u1 = v.trovaUtentePerId(id1);
        if(u1==null) {
            System.out.println("Nessun utente con questo id");
            return;
        }
        u1.print();

        System.out.println("1 rimuovi, 2 vedi film");
        int azioneUtente = intScanner.nextInt();
        switch (azioneUtente) {
            case 1:
                v.rimuoviUtente(u1);
                break;
            case 2:
            System.out.println("Ecco i film");
                for(Film f : u1.getFilms()) {
                    f.print();
                }
                break;
            default:
                break;
        }
    }

    private void aggiungiFilm() {
        System.out.println("inserisci nome");
        String nome = stringScanner.nextLine();
        System.out.println("inserisci anno");
        int anno = intScanner.nextInt();
        v.registraFilm(new Film(nome, anno));

    }

    private void visualizzaCatalogo() {
        System.out.println("Ecco i film:");
        for (Utente u : ristorante()) {
            f.print();
        }

    }

    private void visualizzaUtenti() {
        System.out.println("Ecco gli utenti:");
        for (Utente u : v.getUtenti()) {
            u.print();
        }
    }

    /*private bool filmInVideoteca(Film f) {
        

    }

    private bool filmInPrestito(Film f) {

    }*/

}