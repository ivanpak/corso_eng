public class Critico extends Utente {

    public Critico(String nome, String email, String password, float soldi) {
        super(nome,email,password,soldi);
    }

    // implemento il comportamento dell'utente specificando che il critico assegna una valutazione
    @Override
    public void contribuisci(Ristorante r) {
        System.out.println("Stai assegnando una valutazione");
        System.out.println("Inserisci nome piatto");
        String piatto = Main.stringScanner.nextLine();
        System.out.println("Inserisci valutazione (1-5)");
        int val = Main.intScanner.nextInt();
        int id1 = r.getPiatti().indexOf(piatto);
        if(id1 == -1) {
            System.out.println("Il piatto non esiste");
        } else {
            r.assegnaValutazione(piatto, val);
        }
    }

    @Override
    public String getTipo() {
        return "Critico";
    }
}