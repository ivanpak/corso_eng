class Class1 implements Interface1, Interface2 {
  @Override
  public void func1() {
      System.out.println("ciao1");
  }

  @Override
  public void func2() {
      System.out.println("ciao2");
  }
}

class Main3 {
    public static void main(String[] args) {
      Class1 c1 = new Class1();
      c1.func1();
      c1.func2();
   }
  }