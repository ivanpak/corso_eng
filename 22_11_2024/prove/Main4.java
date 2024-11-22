class Class4 {
    public final void func1() {
      System.out.println("func1");
    }

    public void func1(String s) {
      System.out.println("func1.1");
    }
  }

  class Main4 {
    public static void main(String[] args) {
      Class4 myAnimal = new Class4();
      myAnimal.func1();
      myAnimal.func1("ciao");
   }  }