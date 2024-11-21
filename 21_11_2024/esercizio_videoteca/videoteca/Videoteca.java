import java.util.ArrayList;

public class Videoteca {
    public final static int MAX_NOLEGGI = 3;

    private String nome;
    private ArrayList<Utente> utenti;
    private ArrayList<Film> films;

    public void registraUtente(Utente u) {
        utenti.add(u);
    }

    public void rimuoviUtente(Utente u) {
        int id1 = utenti.indexOf(u);
        if(id1!=-1) {
            films.remove(id1);
        }
    }
    
    public void registraFilm(Film f) {
        films.add(f);
    }

    public boolean filmPresente(Film f) {
        int id1 = films.indexOf(f);
        return id1 !=-1;
    } 

    public boolean utentePresente(Utente u) {
        int id1 = utenti.indexOf(u);
        return id1 !=-1;
    } 

    public void rimuoviFilm(Film f) {
        int id1 = films.indexOf(f);
        if(id1!=-1) {
            films.remove(id1);
        }
    }

    public Utente trovaUtentePerId(int id1) {
        int id1 = utenti.indexOf(new Utente(id1, "", new ArrayList<>()));
        if(id1!=-1) {
            return utenti.get(id1);
        } else {
            return null;
        }
    }

    public Film trovaFilm(Film f) {
        int id1 = films.indexOf(f);
        if(id1!=-1) {
            return films.get(id1);
        } else {
            return null;
        }
    }



    public ArrayList<Film> cercaFilmPerTitolo(String nome) {

    }

    public ArrayList<Film> cercaFilmPerAnno(int anno) {
        
    }

    public int nextId() {
        int id1 = 0;
        for(Utente u : utenti){
            if(u.getId()==id1){
                id1++;
            }
        }
        return id1;
    }

    public Videoteca() {
        nome = "";
        utenti = new ArrayList<>();
        films = new ArrayList<>();
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
