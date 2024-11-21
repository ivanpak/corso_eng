import java.util.ArrayList;


public class Utente {
    private String id;
    private String nome;
    private ArrayList<Film> films;
    
    public Utente(String id, String nome, ArrayList<Film> films) {
        this.id = id;
        this.nome = nome;
        this.films = films;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }
}
