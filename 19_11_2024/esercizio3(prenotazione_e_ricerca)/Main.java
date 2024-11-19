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
            System.out.println("\n------------MENU----------------");
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
                                int ind1 = searchPosition(prenotationNumbers1, prenotationNumbers2, rowNum, colNum);
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
                            ArrayList<Integer> positions = new ArrayList<>();
                            for(int i=0; i<prenotationNames.size(); i++) {
                                System.out.println(prenotationNames.get(i));
                                if(prenotationNames.get(i).equals(nameCercato)) {
                                    positions.add(i);
                                }
                            }

                            if(positions.size() == 0) {
                                System.out.println("nessuna prenotazione per questo utente");
                            } else {
                                for (int i: positions) {
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
                            int ind1 = searchPosition(prenotationNumbers1, prenotationNumbers2, filaCercata, posizioneCercata);
                            if(ind1==-1) {
                                System.out.println("nessuna prenotazione qui");
                            } else {
                                System.out.println(String.format("Nome: %s fila: %d numero: %d", prenotationNames.get(ind1), prenotationNumbers1.get(ind1), prenotationNumbers2.get(ind1)));
                            }
                            break;
                        default:
                            break;
                    }
                    break;

                // visualizza la stanza con tutte le postazioni, indicando per ognuna se è occupata e da chi
                case "visualizza":

                    // converto la lista (3 liste) di prenotazioni unidimensionale in una matrice
                    String[][] arr1 = new String[roomsize1][roomsize2];
                    for (int i=0; i<prenotationNames.size(); i++) {
                        arr1[prenotationNumbers1.get(i)][prenotationNumbers2.get(i)] = prenotationNames.get(i);
                    }

                    // visualizzo la matrice. Gli indici partono da -1 per aggiungere numeri di riga e colonna
                    for (int i=-1; i<roomsize1; i++) {
                        for (int j=-1; j<roomsize2; j++) {
                            String s1 = "";
                            if(i==-1 && j==-1) {
                                s1 = "";
                            }
                            else if(i==-1) {
                                s1 = "" + j;
                            } else if(j==-1) {
                                s1 = "" + i;
                            } else {
                                s1 = arr1[i][j]==null ? "x" : arr1[i][j];
                            }
                            // per evitare di rovinare
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

        stringScanner.close();
        intScanner.close();
    }

    // questa funzione restituisce il primo indice delle liste l1 e l2 al quale si trovano i due valori value1 e value2
    // è utile per trovare una prenotazione in base alle coordinate
    public static int searchPosition(ArrayList<Integer> l1, ArrayList<Integer> l2, Integer value1, Integer value2) {
        assert l1.size() == l2.size();
        int ind1 = -1;
        for(int i=0; i<l1.size(); i++) {
            if(l1.get(i) == value1 && l2.get(i) == value2) {
                ind1 = i;
            }
        }
        return ind1;
    } 
}

