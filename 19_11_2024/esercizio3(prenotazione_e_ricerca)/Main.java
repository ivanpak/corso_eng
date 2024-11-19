import java.util.ArrayList;
import java.util.Scanner;

/*
Scrivi un programma che continua a chiedere all'utente di inserire un numero fino a quando l'utente inserisce un numero negativo. Durante ogni iterazione, controlla con un if se il numero è pari o dispari e stampalo.



Chiedi all'utente di inserire un numero.
Continua a chiedere il numero finché l'utente non inserisce un numero negativo.
Usa if per verificare se il numero è pari o dispari.
Stampa il risultato.
 */

public class Main {
    int x;
    
    // String[][] positions = new String[roomsize1][roomsize2];

    public Main()  {
        System.out.println("contructor");
        x=3;
    }
    
    public static void main(String[] args) {

        int roomsize1 = 3;
        int roomsize2 = 8;

        int stringCutLength = 5;

        ArrayList<String> prenotationNames = new ArrayList<>();
        ArrayList<Integer> prenotationNumbers1 = new ArrayList<>();
        ArrayList<Integer> prenotationNumbers2 = new ArrayList<>();

        Scanner stringScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);

        

        while(true) {
            System.out.println("opzioni");
            String selector = stringScanner.nextLine();
            switch (selector) {
                case "prenota":
                    System.out.println("----");
                    System.out.println("inerisci nome");
                    String name = stringScanner.nextLine();
                    System.out.println("inerisci nome");
                    int rowNum = intScanner.nextInt();
                    System.out.println("inerisci nome");
                    int colNum = intScanner.nextInt();

                    if(!prenotationNumbers1.contains(rowNum) || !prenotationNumbers2.contains(colNum)) {
                        prenotationNames.add(name);
                        prenotationNumbers1.add(rowNum);
                        prenotationNumbers2.add(colNum);
                        System.out.println("Prenotazione inserita");
                    } else {
                        System.out.println("Posto occupato");
                    }
                    break;
                
                case "cerca":
                    System.out.println("opzioni");
                    String selector2 = stringScanner.nextLine();
                    switch (selector2) {
                        case "nome":
                            System.out.println("inerisci nome");
                            String nameCercato = stringScanner.nextLine();
                            
                            for(int i=0; i<prenotationNames.size(); i++) {
                                if(prenotationNames.get(i) == nameCercato) {
                                    System.out.println(String.format("Nome: %s fila: %d numero: %d", prenotationNames.get(i), prenotationNumbers1.get(i), prenotationNumbers2.get(i)));
                                }
                            }
                            break;
                        case "posizione":
                            System.out.println("inerisci numero fila");
                            int filaCercata = intScanner.nextInt();
                            System.out.println("inerisci numero nella fila");
                            int posizioneCercata = intScanner.nextInt();
                            for(int i=0; i<prenotationNames.size(); i++) {
                                if(prenotationNumbers1.get(i) == filaCercata && prenotationNumbers2.get(i) == posizioneCercata) {
                                    System.out.println(String.format("Nome: %s fila: %d numero: %d", prenotationNames.get(i), prenotationNumbers1.get(i), prenotationNumbers2.get(i)));
                                }
                            }
                            break;
                        default:
                            break;
                    }
                    break;

                case "visualizza":
                    String[][] arr1 = new String[roomsize1][roomsize2];
                    for (int i=0; i<prenotationNames.size(); i++) {
                        arr1[prenotationNumbers1.get(i)][prenotationNumbers2.get(i)] = prenotationNames.get(i);
                    }

                    for (int i=0; i<roomsize1; i++) {
                        for (int j=0; j<roomsize1; j++) {

                            System.out.print(arr1[i][j].substring(0,5) + '\t');
                        }
                        System.out.print('\n');
                    }
                    break;
                default:
                    break;
            }
        }
    }
}