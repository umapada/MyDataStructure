package extra;

import java.util.*;

/**
 * Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an
 * element x is the first greater element on the right side of x in array. Elements for which no greater
 * element exist, consider next greater element as -1.
 *
 * Examples:
 *
 * For any array, rightmost element always has next greater element as -1.
 * For an array which is sorted in decreasing order, all elements have next greater element as -1.
 * For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
 * Element       NGE
 *    4      -->   5
 *    5      -->   25
 *    2      -->   25
 *    25     -->   -1
 * d) For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows.
 *
 *
 *
 *   Element        NGE
 *    13      -->    -1
 *    7       -->     12
 *    6       -->     12
 *    12      -->     -1
 */


/**
 * Push the first element to stack.
 * Pick rest of the elements one by one and follow the following steps in loop.
 * Mark the current element as next.
 * If stack is not empty, compare top element of stack with next.
 * If next is greater than the top element,Pop element from stack. next is the next greater element for the popped element.
 * Keep popping from the stack while the popped element is smaller than next. next becomes the next greater element for all such popped elements
 * Finally, push the next in the stack.
 * After the loop in step 2 is over, pop all the elements from stack and print -1 as next element for them.
 */


//Important
public class NextGreaterElement {

    public static void main(String[] args) {
        int arr[] = {4,5,2,25, 23, 5};
//        if(arr.length > 0){
//            Map<Integer, Integer> map = getNextGreaterElement(arr);
//
//            map.keySet().stream().forEach(x -> {
//                System.out.println( x + " -> " +map.get(x));
//            });
//        }

       // int arr1[] = { 11, 13, 21, 3 };
        int n = arr.length;
        printNGE(arr, n);

        Map<Integer, Integer> map = NGE(arr);
        Set<Integer> set = map.keySet();
        System.out.println("==================");
        for(Integer i:set){
            System.out.println(i + " -- > "+ map.get(i));
        }

    }

    /* prints element and NGE pair for all elements of arr[] of size n */
    static void printNGE(int arr[], int n)
    {
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        // stack.push(-1);
        int element, next;

        /* push the first element to stack */
        stack.push(arr[0]);

        // iterate for rest of the elements
        for (i = 1; i < n; i++)
        {
            next = arr[i];

            if (!stack.isEmpty())
            {

                // if stack is not empty, then pop an element from stack
                element = stack.pop();

                /* If the popped element is smaller than next, then a) print the pair b) keep
                   popping while elements are smaller and stack is not empty */
                while ( next > element )
                {
                    System.out.println(element + " --> " + next);
                    if (stack.isEmpty())
                        break;
                    element = stack.pop();
                }

                /* If element is greater than next, then  push the element back */
                if (element > next)
                    stack.push(element);
            }

            /* push next to stack so that we can find next greater for it */
            stack.push(next);
        }

        /* After iterating over the loop, the remaining elements in stack do not have the next greater
           element, so print -1 for them */
        while (stack.isEmpty() == false)
        {
            element = stack.pop();
            next = -1;
            System.out.println(element + " -- " + next);
        }
    }

    static Map<Integer, Integer> NGE(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
       // int[] res = new int[findNums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] > stack.peek())
                map.put(stack.pop(), nums[i]);
            stack.push(nums[i]);
        }
        while(!stack.empty()){
            map.put(stack.pop(), -1);
        }
        return  map;
    }


//   static Map<Integer, Integer>  getNextGreaterElement(int[] n){
//        Map<Integer, Integer> map = new HashMap<>();
//
//        int index = 0;
//        Stack<Integer> stack = new Stack<>();
//
//        //Push first element to stack
//        stack.push(n[0]);
//
//        for(int i =1; i < n.length; i ++){
//            index = i;
//            //Push element into the stack until it find a greater element than a stack top
//            while(n[i] < stack.peek() && index < n.length){
//                stack.push(n[index++]);
//            }
//
//            while(!stack.empty() && n[i] > stack.peek() ){
//                map.put(stack.pop(), n[i]);
//            }
//            stack.push(n[i]);
//            if(index >= n.length){
//                while (!stack.isEmpty()){
//                    map.put(stack.pop(), -1);
//                }
//                break;
//            }
//        }
//        if(!map.isEmpty()){
//            while (!stack.isEmpty()){
//                map.put(stack.pop(), -1);
//            }
//        }
//        return map;
//    }




}
