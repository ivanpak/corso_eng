import java.util.ArrayList;


public class Utente {
    private int id;
    private String nome;
    private ArrayList<Film> films;

    @Override
    public boolean equals(Object obj) {
        System.out.println("my utente equals");
        if (obj == this) {
            return true;
        }
        if (obj instanceof Utente) {
            // Circle circle =  (Circle)obj;
            return this.id == ((Utente)obj).id;
        } else {
            return false;
        }
    }

    public void print() {
        System.out.println(String.format("%d - %s - %d film noleggiati", id, nome, films.size()));
    }
    
    public Utente() {
        id = 0;
        nome = "";
        films = new ArrayList<>();
    }

    public Utente(int id, String nome, ArrayList<Film> films) {
        this.id = id;
        this.nome = nome;
        this.films = films;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
