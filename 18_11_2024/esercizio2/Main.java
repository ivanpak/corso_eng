import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Inizializzazione scanner
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        // Inizializzazione variabili
        String nome = "";
        String password = "";
        int id1 = 0;

        // Ciclo per multipli tentativi di inserimento
        boolean ok = false;
        int i =0;
        while (i<3 & !ok) {
            i++;
            System.out.println("-------INSERISCI DATI-----");
            // Inserimento nome
            System.out.println("Inserisci nome");
            nome = scanner1.nextLine();
            if(nome.length()>5) {
                System.out.println("nome troppo lungo");
                ok = false;
                continue;
            } else if (nome.length()<3) {
                System.out.println("nome troppo corto");
                ok = false;
                continue;
            }

            // Inserimento password
            System.out.println("Inserisci password");
            password = scanner1.nextLine();
            if(password.length()>5) {
                System.out.println("password troppo lunga");
                ok = false;
                continue;
            } else if (nome.length()<3) {
                System.out.println("password troppo corta");
                ok = false;
                continue;
                
            }

            // Inserimento id
            System.out.println("Inserisci id");
            id1 = scanner2.nextInt();
            if(id1<0) {
                System.out.println("id deve essere positivo");
                ok = false;
                continue;
                
            }
            ok = true;
        }
        

        // Chiusura scanner
        scanner1.close();
        scanner2.close();


        // Print risultati
        System.out.println("-------RISULTATI-----");
        if(ok) {
            // Creazione stringa password oscurata
            String repeated = new String(new char[password.length()]).replace("\0", "*");

            System.out.println("Nome: " + nome );
            System.out.println("Password: " + repeated );
            System.out.println("Id: " + id1 );
        } else {
            System.out.println("Inserimento dati non riuscito");
        }

        
    }

}