

class Giocattolo {
    string name {get; set;}
    string tipoMateriale {get; set;}
    decimal prezzoProd {get; set;}
    decimal prezoVend {get; set;}

    public decimal getMargin() {
        return prezoVend-prezzoProd;
    }
}

class FabbricaGiocattoli {
    private List<Giocattolo> giocattoli;

    FabbricaGiocattoli() {
        giocattoli = new List<Giocattolo>();
    }
    void addGiocattolo(Giocattolo g) {
        giocattoli.Add(g);
    }

    void print() {
        Console.WriteLine(string.Join(" ", giocattoli));
    }

    decimal getTotalMargin() {
        return giocattoli.Sum(g => g.getMargin());
    }
}
class Program {
    public static void Main(string[] args) {
        while(true) {
            Console.WriteLine("");
        }
    }

}