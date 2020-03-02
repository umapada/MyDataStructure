package extra;

import java.util.*;

@FunctionalInterface
interface FI{
    int add(int a, int b);
    default void print(){
        System.out.println("Hello from print");
    }
}


public class MyClass {

    public static void main(String[] args) {
        Integer[] arr = {3,5,2,8,6};
        List<Integer> list = Arrays.asList(arr);

        Collections.sort(list,(a,b) -> Integer.compare(b,a));

        list.stream().forEach(x->{
            System.out.println(x);
        });
    }


}




