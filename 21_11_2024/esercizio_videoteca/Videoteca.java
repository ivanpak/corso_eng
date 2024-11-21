import java.util.ArrayList;

public class Videoteca {
    private String nome;
    private ArrayList<Utente> utenti;
    private ArrayList<Film> films;
    
    public Videoteca() {
    }

    public Videoteca(String nome, ArrayList<Utente> utenti, ArrayList<Film> films) {
        this.nome = nome;
        this.utenti = utenti;
        this.films = films;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Utente> getUtenti() {
        return utenti;
    }

    public void setUtenti(ArrayList<Utente> utenti) {
        this.utenti = utenti;
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }
}
