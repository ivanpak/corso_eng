public class Film {
    private String titolo;
    private int annoUscita;

    // @Overload
    public boolean equals(Film f) {
        System.out.println("my film equals");
        return this.titolo == f.titolo && this.annoUscita == f.annoUscita;
    }

    public void print() {
        System.out.println(String.format("%s - %d", titolo, annoUscita));
    }

    public Film(String titolo, int annoUscita) {
        this.titolo = titolo;
        this.annoUscita = annoUscita;
    }

    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public int getAnnoUscita() {
        return annoUscita;
    }
    public void setAnnoUscita(int annoUscita) {
        this.annoUscita = annoUscita;
    }
}
