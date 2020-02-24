package extra;

import java.util.*;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

class Parent{
    String name;
//    Parent(){
//        this.name= "Hello Parent";
//    }
    Parent(String name){
        this.name = name;
    }
}
class Child extends Parent{

    String name;
//    Child(){
//        super("pp");
//    }
    Child(String name){
        super(name);
        this.name = name;
    }
}
public class MyClass {

    public static void main(String[] args) {
        int [] a = {3,4,5,2,6,7,7,-3};

        String str = "Hello how are you";

        String [] s = str.split(" ");

        int i = s[0].length();

        System.out.println(i);



    }



}




