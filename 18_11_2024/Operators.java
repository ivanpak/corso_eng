import java.util.Scanner;

public class Operators {
    public static void main(String[] args) {

        String txt = "ciaone Eccomi 'sono' Arrivato";
        System.out.println("eccolo: "  + txt.length());
        System.out.println("eccolo: "  + txt.toUpperCase());
        System.out.println("eccolo: "  + txt.toLowerCase());
        System.out.println("eccolo: "  + txt.indexOf("sono"));
        System.out.println("eccolo".concat("sas").concat("_lel"));

    }

    public void func2() {
        System.out.println("ok dai");
    }

}