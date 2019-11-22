package extra;

public interface LambInt1 {
    public void apply1();
   // public void apply2(String arg1);
  //  public void apply2(int arg1);

    static void apply(){
        System.out.println("Hello from Interface ...");
    }


    public default  void apply2(){
        System.out.println("Hello default 1");
    }

    public default  void apply3(){
        System.out.println("Hello default 2");
    }
}
