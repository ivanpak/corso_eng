import java.util.ArrayList;
import java.util.Scanner;

/*
Faccio inserire al max 3 valori. Ad ogni valore inserito calcolo la somma. Se è negativa stoppo il ciclo.
Alla fine mostro i valori inseriti e la loro somma.
 */

public class Chef {

  public String nome = "";
  public String tipo = "italiano";
  public ArrayList<String> ingredienti = new ArrayList<>();
  public ArrayList<ArrayList<String>> ricette = new ArrayList<>()

  public Libro (String nome, String tipo, ArrayList<String> ingredienti) {
    this.nome = nome;
    this.tipo = tipo;
    this.ingredienti = ingredienti;
  }

  public ArrayList<String> creaPiatto() {
    switch (tipo) {
      case "italiano":
        if(ricettaPossibile())
        break;
    
      default:
        break;
    }
  }

  public boolean ricettaPossibile(ArrayList<String> ings) {
    boolean ok = true;
    for (String ing: ings) {
      if(!ingredienti.contains(ing)) {
        System.out.println(ing + " mancante");
        ok = false;
      }
    }
    return ok;
  }
}