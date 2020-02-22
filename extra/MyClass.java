package extra;


import java.util.*;

public class MyClass {

    static void a1(int [] ar){
        ar[0] = 200;
    }

    static void a2(int [] ar){
        ar[0] = 400;
    }

    public static void main(String[] args) {

    int[] a = {3,4,1,7,8,0,4};
        print(a);
        a1(a);
        print(a);
        a2(a);
        print(a);
    }


static void print(int[] ar){
        Arrays.stream(ar).forEach(x->{
            System.out.print(x + " ");
        });
    System.out.println("--------------");
}


}

class CHAR{
    char chr;
    int count;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CHAR aChar = (CHAR) o;
        return (count == aChar.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chr, count);
    }
}