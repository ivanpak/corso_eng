class Outer {
    void func1() {
      System.out.println("outer");
    }
    class Inner {
      void func2() {
        System.out.println("inner");
      }
    }
  }

  class Main2 {
    public static void main(String[] args) {
      Outer o1 = new Outer();
      o1.func1();
   } 
  }