package extra;

public class MyClass {

    static LambInt1 intf = () -> {
        System.out.println("Hello Lambda");
    };

    public static void main(String[] args) {
        LambInt1.apply();

        intf.apply1();

        intf.apply2();
        intf.apply3();
    }
}
