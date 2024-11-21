public class Chef extends Utente {

    public Chef(String nome, String email, String password, float soldi) {
        super(nome,email,password,soldi);
    }

    @Override
    public void contribuisci(Ristorante r) {
        System.out.println("Inserisci nome piatto");
        String piatto = Main.stringScanner.nextLine();
        r.getPiatti().add(piatto);
    }
}