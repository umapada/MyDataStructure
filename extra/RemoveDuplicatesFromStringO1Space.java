package extra;

import java.util.Arrays;

public class RemoveDuplicatesFromStringO1Space {


    public static void main(String[] args) {

        // Method 1
        String str = "geeksforgeeks";
        char[] chr = str.toCharArray();
        int len = chr.length;

        int index = 0;
        int j;
        for(int i=0; i < len; i ++){

            for(j = 0; j < i; j++){
                if(chr[i] == chr[j]){
                    break;
                }
            }

            if(i==j){
                chr[index++] = chr[i];
            }

        }
        System.out.println( String.valueOf(Arrays.copyOf(chr,index)));

        //Method 2
        chr = str.toCharArray();

        int bit = 0;
       // int counter = 0;
        int length = 0;

        for(int i =0; i < len; i++){
            int x = chr[i] - 97;

            if((bit & (1 << x)) == 0 ){
                chr[length++] = chr[i];
            }

            bit = bit | (1 << x);
        }

        System.out.println(String.valueOf(Arrays.copyOf(chr,length)));

    }





}
