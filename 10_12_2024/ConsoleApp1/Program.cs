

using System.Security.Cryptography;

public abstract class ProdottoSoftware {
    public string nome {get; private set;}
    public float prezzoVendita {get; private set;}

    public ProdottoSoftware(string nome, float prezzoVendita) {
        this.nome = nome;
        this.prezzoVendita = prezzoVendita;
    }

    public abstract float calcolaGuadagno();
}

public class WebApp : ProdottoSoftware
{
    public float costoServer {get; private set;}

    public WebApp(string nome, float prezzoVendita, float costoServer) : base(nome, prezzoVendita) {
        this.costoServer = costoServer;
    }
    public override float calcolaGuadagno()
    {
        return prezzoVendita - costoServer;
    }
}

public class MobileApp : ProdottoSoftware
{
    public float costoPubblicazione {get; private set;}

    public MobileApp(string nome, float prezzoVendita, float costoPubblicazione) : base(nome, prezzoVendita) {
        this.costoPubblicazione = costoPubblicazione;
    }
    public override float calcolaGuadagno()
    {
        return prezzoVendita - costoPubblicazione;
    }
}

class Program {
    public static void Main(string[] args) {
        List<ProdottoSoftware> prodotti = new List<ProdottoSoftware>();
        prodotti.Add(new WebApp("sito1", 10, 5));
        prodotti.Add(new MobileApp("app1", 6, 2));
        prodotti.Add(new WebApp("sito2", 15, 8));
        // mostra somma dei guagagni da tutti i prodotti
        Console.WriteLine(prodotti.Sum(p => p.calcolaGuadagno()));
        Console.WriteLine(prodotti[0].nome);
    }
}
