class Outer {
    void func1() {
      System.out.println("outer");
    }
    static class Inner {
      void func2() {
        System.out.println("inner");
      }
    }
  }

  class Main2 {
    public static void main(String[] args) {
      Outer o1 = new Outer();
      Outer.Inner i1 = new Outer.Inner();
      // o1.func1();
      i1.func2();

   } 
  }