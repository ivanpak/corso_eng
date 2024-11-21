import java.util.ArrayList;
import java.util.Scanner;

public class MenuVideoteca {

    Scanner stringScanner;
    Scanner intScanner;
    Videoteca v;

    public MenuVideoteca(Videoteca v) {
        this.v = v;
    }

    public void menu() {
        stringScanner = new Scanner(System.in);
        intScanner = new Scanner(System.in);
        loop1: while(true) {
            System.out.println("-------MENU------------");
            System.out.println("1 aggiungi utente");
            System.out.println("2 gestisci utente");
            System.out.println("3 aggiungi film");
            System.out.println("4 gestisci film");
            System.out.println("5 cerca film");
            System.out.println("6 visualizza catalogo");
            System.out.println("7 visualizza utenti");
            String selezione = stringScanner.nextLine();
            switch (selezione) {
                case "1":
                aggiungiUtente();
                break;
            case "2":
                gestisciUtente();
                break;
            case "3":
                aggiungiFilm();
                break;
            case "4":
                gestisciFilm();
                break;
            case "5":
                cercaFilm();
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
        System.out.println("rimuovi ? 1");
        int azioneUtente = intScanner.nextInt();

        Utente u1 = v.trovaUtentePerId(id1);

        switch (azioneUtente) {
            case 1:
                v.rimuoviUtente(u1);
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
        int id1 = v.nextId();
        v.registraFilm(new Film(nome, anno));

    }

    private void gestisciFilm() {
        System.out.println("inserisci nome");
        String nome = intScanner.nextLine();
        System.out.println("inserisci anno");
        int anno = intScanner.nextInt();
        Film f1 = new Film(nome, anno);
        System.out.println("rimuovi ? 1");
        int azioneUtente = intScanner.nextInt();

        switch (azioneUtente) {
            case 1:
                v.rimuoviFilm(f1);
                break;
            default:
                break;
        }
    }

    private void cercaFilm() {
        System.out.println("1 per nome, 2 per anno");
        int azioneUtente = intScanner.nextInt();

        ArrayList<Film> fs = new ArrayList<>();
        switch (azioneUtente) {
            case 1:
                System.out.println("inserisci nome");
                String nome = stringScanner.nextLine();
                fs = v.cercaFilmPerTitolo(nome);
                break;
            case 2:
                System.out.println("inserisci anno");
                int anno = intScanner.nextInt();
                fs = v.cercaFilmPerAnno(anno);
                break;
            default:
                break;
        }

        System.out.println("Ecco i film:");
        for (Film f : fs) {
            f.print();
        }

    }

    private void visualizzaCatalogo() {
        System.out.println("Ecco i film:");
        for (Film f : v.getFilms()) {
            f.print();
        }

    }

    private void visualizzaUtenti() {
        System.out.println("Ecco gli utenti:");
        for (Utente u : v.getUtenti()) {
            u.print();
        }
    }

    private bool filmInVideoteca(Film f) {

    }

    private bool filmInPrestito(Film f) {

    }

}