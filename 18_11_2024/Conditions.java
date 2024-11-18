import java.util.Scanner;

public class Conditions {
    public static void main(String[] args) {

        Scanner scanner1 = new Scanner(System.in);
        // Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter 1");

        // String in1 = scanner1.nextLine();
        int in1 = scanner1.nextInt();
        /*if(in1<5) {
            System.out.println("less than 5");    
        } else if(in1>5) {
            System.out.println("more than 5");    
        } else {
            System.out.println("equal to 5");    
        }*/

        switch (in1) {
            case 1:
                System.out.println("uno");
                break;
            case 2:
                System.out.println("due");
                break;
            case 3:
                System.out.println("tre");
                break;
            default:
                System.out.println("un altro");
                break;
        }

        scanner1.close();

    }

    public void func2() {
        System.out.println("ok dai");
    }

}