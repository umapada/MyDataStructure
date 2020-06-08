package TEST;


import java.math.BigDecimal;
import java.util.*;

class TEST {

static int count = 0;
    public static void main(String[] nums) {
        int [] A = new int[5];
        binary(5, A);

    }

    static void binary(int n, int []A){
        if(n<1){
           // Arrays.stream(A)
            Arrays.stream(A).forEach(System.out::print);
            System.out.println(" -> "+count++);
        }else{
            A[n-1] = 0;
            binary(n-1, A);
            A[n-1] = 1;
            binary(n-1, A);
        }
    }


}






