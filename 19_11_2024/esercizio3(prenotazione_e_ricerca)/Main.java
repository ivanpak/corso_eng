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
    
    public static void main(String[] args) {

        int roomsize1 = 3;
        int roomsize2 = 8;

        int stringCutLength = 4;

        ArrayList<String> prenotationNames = new ArrayList<>();
        ArrayList<Integer> prenotationNumbers1 = new ArrayList<>();
        ArrayList<Integer> prenotationNumbers2 = new ArrayList<>();

        Scanner stringScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);
        

        // Loop del menu
        loop1: while(true) {
            System.out.println("------------MENU----------------");
            System.out.println("Inserisci stringa: prenota, cerca, visualizza, report o chiudi?");
            String selector = stringScanner.nextLine();
            
            // seleziona l'operazione da eseguire
            switch (selector) {

                // prenotazione
                case "prenota":
                    System.out.println("----");
                    System.out.println("inerisci nome");
                    String name = stringScanner.nextLine();
                    System.out.println("inerisci fila");
                    int rowNum = intScanner.nextInt();
                    System.out.println("inerisci posizione nella fila");
                    int colNum = intScanner.nextInt();

                    // se la posizione non è occupata
                    if(!prenotationNumbers1.contains(rowNum) || !prenotationNumbers2.contains(colNum)) {
                        prenotationNames.add(name);
                        prenotationNumbers1.add(rowNum);
                        prenotationNumbers2.add(colNum);
                        System.out.println("Prenotazione inserita");
                    } else {
                        // se la posizioone è occupata
                        System.out.println("Posto occupato, procedere ugualmente?");
                        String sovrascrivere = stringScanner.nextLine();

                        //seleziona se sovrascrivere o meno l'operazione
                        switch (sovrascrivere) {

                            //trovo l'indice della prenotazione e sovrascrivo le coordinate
                            case "yes":
                                int ind1 = 0;
                                for(int i=0; i<prenotationNames.size(); i++) {
                                    if(prenotationNumbers1.get(i) == rowNum && prenotationNumbers2.get(i) == colNum) {
                                        ind1 = i;
                                    }
                                }
                                prenotationNames.set(ind1, name);
                                break;
                            
                            // torno al menu
                            case "no":
                                System.out.println("torno al menu");
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                
                // cerca una prenotazione
                case "cerca":
                    System.out.println("Inserisci stringa: nome o posizione?");
                    String selector2 = stringScanner.nextLine();

                    // seleziona se cercare per nome o per coordinate
                    switch (selector2) {

                        // cerco e mostro tutte le prenotazioni legate a un nome
                        case "nome":
                            System.out.println("inerisci nome");
                            String nameCercato = stringScanner.nextLine();
                            
                            for(int i=0; i<prenotationNames.size(); i++) {
                                System.out.println(prenotationNames.get(i));
                                if(prenotationNames.get(i).equals(nameCercato)) {
                                    System.out.println(String.format("Nome: %s fila: %d numero: %d", prenotationNames.get(i), prenotationNumbers1.get(i), prenotationNumbers2.get(i)));
                                }
                            }
                            break;

                        // cerco la prenotazione per coordinate e la mostro
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

                // visualizza la stanza con tutte le postazioni, indicando per ognuna se è occupata e da chi
                case "visualizza":

                    // converto la lista (liste) di prenotazioni unidimensionale in una matrice
                    String[][] arr1 = new String[roomsize1][roomsize2];
                    for (int i=0; i<prenotationNames.size(); i++) {
                        arr1[prenotationNumbers1.get(i)][prenotationNumbers2.get(i)] = prenotationNames.get(i);
                    }

                    // visualizzo la matrice
                    for (int i=0; i<roomsize1; i++) {
                        for (int j=0; j<roomsize2; j++) {
                            String s1 = arr1[i][j]==null ? "x" : arr1[i][j];
                            String subString = (s1.length()>stringCutLength) ? s1.substring(0,stringCutLength) + "..." : s1;
                            System.out.print(subString + '\t');
                        }
                        System.out.print('\n');
                    }
                    break;

                // mostro il numero e la percentuale di postazioni occupate
                case "report":
                    System.out.println(String.format("%d posti occupati su %s (%.1f)%%", prenotationNames.size(), roomsize1*roomsize2, (100*(float)prenotationNames.size())/((float)(roomsize1*roomsize2))));
                    break;
                
                // esci dal menu
                case "chiudi":
                    System.out.println("arrivederci");
                    break loop1;
                
                default:
                    System.out.println("comando non supportato");
                    break;
            }
        }
    }
}

