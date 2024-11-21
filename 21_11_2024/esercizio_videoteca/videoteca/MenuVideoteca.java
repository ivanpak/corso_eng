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
            System.out.println();
            System.out.println("-------MENU------------");
            System.out.println("1 aggiungi utente");
            System.out.println("2 gestisci utente");
            System.out.println("3 aggiungi film");
            System.out.println("4 gestisci film");
            System.out.println("5 cerca film");
            System.out.println("6 visualizza catalogo");
            System.out.println("7 visualizza utenti");
            System.out.println("-----------------------");
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

    private void gestisciFilm() {
        System.out.println("inserisci nome");
        String nome = stringScanner.nextLine();
        System.out.println("inserisci anno");
        int anno = intScanner.nextInt();
        Film f1 = new Film(nome, anno);
        loop2: while(true) {
            f1.print();
            System.out.println("1 rimuovi, 2 assegna a utente, 3 rientra in libreria, 4 chi lo possiede");
            int azioneUtente = intScanner.nextInt();

            switch (azioneUtente) {
                case 1:
                    // rimuovi film
                    v.rimuoviFilm(f1);
                    break;
                case 2:
                    // assegna a utente
                    System.out.println("inserisci id utente");
                    int idUtente = intScanner.nextInt();
                    Utente u = new Utente(idUtente, null, null);
                    int idUtenteDb = v.getUtenti().indexOf(u);
                    if(idUtenteDb==-1) {
                        System.out.println("utente inesistente");
                    } else {
                        Utente u2 = v.proprietarioFilm(f1);
                        if(u2 == null) {
                            v.getUtenti().get(idUtenteDb).getFilms().add(f1);
                        } else {
                            System.out.println("film posseduto da altro utente");
                        }
                    }
                    break;
                case 3:
                    Utente u3 = v.proprietarioFilm(f1);
                    if(u3==null) {
                        System.out.println("film gia in videoteca");
                    } else {
                        int idF = u3.getFilms().indexOf(f1);
                        u3.getFilms().remove(idF);
                        System.out.println("film riportato in videoteca con successo");
                    }
                    break;
                case 4:
                    Utente u4 = v.proprietarioFilm(f1);
                    if(u4 == null) {
                        System.out.println("il film è in videoteca, quindi non posseduto da nessun utente");
                    } else {
                        System.out.println("il film è noleggiato da");
                        u4.print();
                    }
                    break;
                default:
                    break loop2;
            }
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

    /*private bool filmInVideoteca(Film f) {
        

    }

    private bool filmInPrestito(Film f) {

    }*/

}