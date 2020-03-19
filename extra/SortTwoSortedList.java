package extra;

import java.util.Arrays;



/**
 * SortTwoSortedList class will merge two sorted list into single sorted list
 * Date: 01/17/2020
 * Author: Umapada Manna
 */

/**
 * e.g.
 * Input: 1->2->4, 1->3->4
 *
 * Output: 1->1->2->3->4->4
 */


public class SortTwoSortedList {

    public static void main(String[] args) {

       int [] list1 = {1,3,5,6};
       int [] list2 = {1,2,3,3,4,4,5};

       int size1 = list1.length;
       int size2 = list2.length;

       //Define output array of length of both array
       int [] out = new int[size1 + size2];
       int j =0;
        int i = 0;
       int index = 0;

       //Iterate both list and add the smaller one to output array
        while(i < size1 && j < size2){

           if(list1[i] > list2[j]){
               out[index++] = list2[j++];
           }else{
               out[index++] = list1[i++];
           }
       }

        // From below two while loop, only one may execute from above output

        //If any data left in first list add in output list
        while(i < size1){
            out[index++] = list1[i++];
        }

        // If any data left in second list, add it to output list
        while(j < size2){
            out[index++] = list1[j++];
        }

        // Print all the element from output list
        Arrays.stream(out).forEach(x -> {
            System.out.print(x + " - ");
        });
    }

}
