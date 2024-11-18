import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Inizializzazione scanner
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        // Inserimento nome
        System.out.println("Inserisci nome");
        String nome = scanner1.nextLine();
        if(nome.length()>5) {
            System.out.println("nome troppo lungo");
        } else if (nome.length()<3) {
            System.out.println("nome troppo corta");
        }

        // Inserimento password
        System.out.println("Inserisci password");
        String password = scanner1.nextLine();
        if(password.length()>5) {
            System.out.println("password troppo lunga");
        } else if (nome.length()<3) {
            System.out.println("password troppo corta");
        }

        // Inserimento id
        System.out.println("Inserisci id");
        int id1 = scanner2.nextInt();
        if(id1<0) {
            System.out.println("id deve essere positivo");
        }

        // Chiusura scanner
        scanner1.close();
        scanner2.close();

        // Creazione stringa password oscurata
        String repeated = new String(new char[password.length()]).replace("\0", "*");

        // Print risultati
        System.out.println("------------");
        System.out.println("Nome: " + nome );
        System.out.println("Password: " + repeated );
        System.out.println("Id: " + id1 );
    }

}