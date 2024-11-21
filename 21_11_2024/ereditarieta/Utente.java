public abstract class Utente extends Ristorante {
    protected String nome;
    protected String email;
    protected String password;
    protected float soldi;

    public abstract void contribuisci(Ristorante r);
    
    public Utente(String nome, String email, String password, float soldi) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.soldi = soldi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getSoldi() {
        return soldi;
    }

    public void setSoldi(float soldi) {
        this.soldi = soldi;
    }

    
}
