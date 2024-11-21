

public class Main {
    public static void main(String[] args) {
        System.out.println("in main");
        Videoteca v = new Videoteca();
        MenuVideoteca mv = new MenuVideoteca(v);
        mv.menu();
    }
}