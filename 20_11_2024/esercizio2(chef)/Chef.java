import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
Faccio inserire al max 3 valori. Ad ogni valore inserito calcolo la somma. Se è negativa stoppo il ciclo.
Alla fine mostro i valori inseriti e la loro somma.
 */

public class Chef {

  public String nome = "";
  public String tipo = "italiano";
  public ArrayList<String> ingredienti = new ArrayList<>();
  public ArrayList<String> nomiRicette = new ArrayList<>(Arrays.asList("veneto", "romano", "siciliano", "turco", "greco"));
  public ArrayList<ArrayList<String>> ricette =  new ArrayList<>(Arrays.asList(
    new ArrayList<>(Arrays.asList("Pasta", "Manzo")),
    new ArrayList<>(Arrays.asList("Manzo", "Pomodoro")),
    new ArrayList<>(Arrays.asList("Pasta", "Pomodoro")),
    new ArrayList<>(Arrays.asList("Pasta", "Pesto")),
    new ArrayList<>(Arrays.asList("Pasta", "Vongole"))
  ));

  public Chef (String nome, String tipo, ArrayList<String> ingredienti) {
    this.nome = nome;
    this.tipo = tipo;
    this.ingredienti = ingredienti;
  }

  public ArrayList<String> creaPiatto() {
    ArrayList<String> ricetta;
    switch (tipo) {
      case "veneto":
        ricetta = ricette.get(nomiRicette.indexOf("veneto"));
        if(ricettaPossibile(ricetta)) {
          // System.out.println("Ecco la ricetta: " + ricetta.toString());
          return ricetta;
        } else {
          System.out.println("Alcuni ingredienti mancanti");
        }
        break;
      case "romano":
        ricetta = ricette.get(nomiRicette.indexOf("romano"));
        if(ricettaPossibile(ricetta)) {
          return ricetta;
        } else {
          System.out.println("Alcuni ingredienti mancanti");
        }
        break;
      case "siciliano":
        ricetta = ricette.get(nomiRicette.indexOf("siciliano"));
        if(ricettaPossibile(ricetta)) {
          return ricetta;
        } else {
          System.out.println("Alcuni ingredienti mancanti");
        }
        break;
      case "turco":
        ricetta = ricette.get(nomiRicette.indexOf("turco"));
        if(ricettaPossibile(ricetta)) {
          return ricetta;
        } else {
          System.out.println("Alcuni ingredienti mancanti");
        }
        break;
      case "greco":
        ricetta = ricette.get(nomiRicette.indexOf("greco"));
        if(ricettaPossibile(ricetta)) {
          return ricetta;
        } else {
          System.out.println("Alcuni ingredienti mancanti");
        }
        break;
    
      default:
        return null;
    }
    return null;
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