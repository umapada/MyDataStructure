package TEST;

import java.util.*;

public interface INTF {
    void print();
    default void p (){
        System.out.println("Hello 1");
    }
}

class A implements INTF{

    static void pp(INTF a){

    }
    public void print(){

    }

    public static void main(String[] args) {


        INTF i = () ->{
            System.out.println("Hello");
        };

        i.print();
        i.p();

        StringBuilder sb = new StringBuilder();

        pp(A::new);

        Optional<A> a = Optional.empty();
        if(a.isPresent())
        a.get().print();


    }
}
