class Persona {
    String name;

    

    public Persona(String name) {
        this.name = name;
    }



    void saluta() {
        System.out.println("ciao, sono una persona: " + name);
    }

    void saluta(String saluto) {
        System.out.println(saluto + ", sono una persona: " + name);
    }
}

class Pirata extends Persona {

    public Pirata(String name) {
        super(name);
    }

    @Override
    void saluta() {
        System.out.println("ciao, sono un pirata: " + name);
    }

    @Override
    void saluta(String saluto) {
        System.out.println(saluto + ", sono un pirata: " + name);
    }
}

class Main {
    public static void main(String[] args) {

        Persona p1 = new Persona("ivan");
        Persona p2 = new Pirata("paolo");

        p1.saluta();
        p2.saluta();

        p1.saluta("hola");
        p2.saluta("argh!!");
        
    }
}