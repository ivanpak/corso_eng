import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        /*double d1 = 9.360d;
        System.out.println(d1);
        int i1 = (int) d1;
        System.out.println(i1);*/

        Scanner scanner1 = new Scanner(System.in);
        // Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter 1");

        // String in1 = scanner1.nextLine();
        int intIn1 = scanner1.nextInt();
        System.out.println("Enter 1");
        int intIn2 = scanner1.nextInt();
        // String stringIn1 = scanner2.nextLine();
        float f2 = (float) intIn1;
        scanner1.close();
        // scanner2.close();
        // System.out.println(stringIn1 + ": "  + f2);
        System.out.println(intIn2 + ": "  + f2);


    }

    public void func2() {
        System.out.println("ok dai");
    }

}

/*
class MiaClasse {
    public static void main(String[] args) {
        System.out.println("main2");
    }
}*/