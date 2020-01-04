package extra;

public class MyClass {

    static LambInt1 intf = (int a) -> {
        System.out.println("Hello Lambda " + a);
    };

    public static void main(String[] args) {

        LambInt1 lmd = a ->{
            System.out.println("Hello There ... "  + a);
        };

        intf.apply1(10);

        lmd.apply1(20);

        LambInt1.apply();

//        LambInt1.apply();
//
//        intf.apply1();
//
//        intf.apply2();
//        intf.apply3();
    }
}
