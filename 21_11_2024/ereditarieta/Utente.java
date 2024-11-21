public abstract class Utente extends Ristorante {
    protected String nome;
    protected String email;
    protected String password;
    protected float soldi;

    public abstract void contribuisci(Ristorante r);

    public void print() {
        System.out.println(String.format("%s - %s - %s - %.2f", nome, email, this.getTipo(), soldi));
    }

    public abstract String getTipo();
    
    public Utente(String nome, String email, String password, float soldi) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.soldi = soldi;
    }

    public boolean credenzialiCorrette(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
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
