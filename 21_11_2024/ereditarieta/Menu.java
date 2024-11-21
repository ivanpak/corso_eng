import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Menu {

    Scanner stringScanner;
    Scanner intScanner;
    Ristorante ristorante;
    ArrayList<Utente> utenti;
    Utente utenteLoggato;

    public Menu(Ristorante r) {
        stringScanner = Main.stringScanner;
        intScanner = Main.intScanner;
        this.ristorante = r;
        this.utenti = new ArrayList<>();
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
            if(utenteLoggato != null) {
                System.out.println(String.format("## Loggato come: %s (%s) ##", utenteLoggato.getNome(), utenteLoggato.getTipo()));
            }
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
        System.out.println("inserisci password");
        String password = stringScanner.nextLine();
        System.out.println("inserisci email");
        String email = stringScanner.nextLine();
        System.out.println("inserisci tipo: chef/critico");
        String tipo = stringScanner.nextLine();
        Float soldi = (new Random()).nextFloat()*100;
        Utente u1;
        if(tipo == "chef") {
            u1 = new Chef(nome, email, password, soldi);
        } else if(tipo == "critico") {
            u1 = new Critico(nome, email, password, soldi);
        } else {
            System.out.println("tipo non accettato");
            return;
        }
        utenti.add(u1);
    }

    private void login() {
        System.out.println("inserisci email");
        String email = stringScanner.nextLine();
        System.out.println("inserisci password");
        String password = stringScanner.nextLine();
        for(Utente u: utenti) {
            if(u.credenzialiCorrette(email, password)) {
                this.utenteLoggato = u;
            }
        }
        System.out.println("login effettuato!");
    }

    private void contribuisci() {
        if(this.utenteLoggato == null) {
            System.out.println("Devi essere loggato");
        } else {
            this.utenteLoggato.contribuisci(this.ristorante);
        }
    }

    private void visualizzaCatalogo() {
        System.out.println("Ecco i piatti e le valutazioni:");
        for (int i =0; i<ristorante.getPiatti().size(); i++) {
            System.out.println(ristorante.getPiatti().get(i));
            System.out.println(ristorante.getValutazioni().get(i));
        }

    }

    private void visualizzaUtenti() {
        System.out.println("Ecco gli utenti:");
        for (int i =0; i<utenti.size(); i++) {
            utenti.get(i).print();
        }
    }

}