

class Giocattolo {
    string name {get; set;}
    string tipoMateriale {get; set;}
    decimal prezzoProd {get; set;}
    decimal prezzoVend {get; set;}

    public Giocattolo(string n, string t, decimal pp, decimal pv) {
        name = n;
        tipoMateriale = t;
        prezzoProd = pp;
        prezzoVend = pv;
    }

    public decimal getMargin() {
        return prezzoVend-prezzoProd;
    }

    public string toString() {
        return $"{name}\t{tipoMateriale}\t{prezzoProd}\t{prezzoVend}";
    }
}

class FabbricaGiocattoli {
    private List<Giocattolo> giocattoli;

    public FabbricaGiocattoli() {
        giocattoli = new List<Giocattolo>();
    }
    public void addGiocattolo(Giocattolo g) {
        giocattoli.Add(g);
    }

    public void print() {
        Console.WriteLine(string.Join("\n", giocattoli.Select(g => g.toString()).ToList()));
    }

    public decimal getTotalMargin() {
        return giocattoli.Sum(g => g.getMargin());
    }
}
class Program {
    public static void Main(string[] args) {

        FabbricaGiocattoli fabbricaGiocattoli = new FabbricaGiocattoli();

        while(true) {
            Console.WriteLine("1 nuovo giocattolo \n 2 mostra giocattoli \n 3 mostra guadagno totale \n 4 esci");
            string s1 = Console.ReadLine();
            int i1 = 1;
            int.TryParse(s1, out i1);
            switch(i1) {
                case 1:
                    Console.WriteLine("inserisci nome");
                    string nome = Console.ReadLine();
                    Console.WriteLine("inserisci tipo");
                    string tipo = Console.ReadLine();
                    Console.WriteLine("inserisci prezzoVend");
                    decimal prezzoProd = 0.0M;
                    s1 = Console.ReadLine();
                    decimal.TryParse(s1, prezzoProd);
                    Console.WriteLine("inserisci prezzoVend");
                    decimal prezzoVend = decimal.TryParse(Console.ReadLine());
                    Giocattolo g = new Giocattolo(nome, tipo, prezzoProd, prezzoVend);
                    break;
                case 2:
                    fabbricaGiocattoli.print();
                    break;
                case 3:
                    decimal earning = fabbricaGiocattoli.getTotalMargin();
                    Console.WriteLine(earning);
                    break;
                default:
                    return;
            }
        }
    }

}