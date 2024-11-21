import java.util.ArrayList;

public class Ristorante {
    private ArrayList<String> piatti;
    private ArrayList<Integer> valutazioni;

    public void aggiungiPiatto(String piatto) {
        piatti.add(piatto);
    }

    public void assegnaValutazione(String piatto, int val) {
        int id1 = piatti.indexOf(piatto);
        if(id1==-1) {
            System.out.println("Non esiste questo piatto");
        } else {
            valutazioni.set(id1, val);
        }
    }

    public Ristorante() {
        piatti = new ArrayList<>();
        valutazioni = new ArrayList<>();
    }

    public ArrayList<String> getPiatti() {
        return piatti;
    }

    public void setPiatti(ArrayList<String> piatti) {
        this.piatti = piatti;
    }

    public ArrayList<Integer> getValutazioni() {
        return valutazioni;
    }

    public void setValutazioni(ArrayList<Integer> valutazioni) {
        this.valutazioni = valutazioni;
    }

}
