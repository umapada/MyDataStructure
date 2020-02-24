package LeetContest;

/**
 * Given an integer num, find the closest two integers in absolute difference whose product equals num + 1 or num + 2.
 *
 * Return the two integers in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 8
 * Output: [3,3]
 * Explanation: For num + 1 = 9, the closest divisors are 3 & 3, for num + 2 = 10, the closest divisors are 2 & 5, hence 3 & 3 is chosen.
 * Example 2:
 *
 * Input: num = 123
 * Output: [5,25]
 * Example 3:
 *
 * Input: num = 999
 * Output: [40,25]
 */


class ClosestDivisors {

    public static void main(String[] args) {
        int p [] = closestDivisors(8);
        System.out.println();
        System.out.println(p[0] + " " + p[1]);
    }

    public static  int[] closestDivisors(int num) {
        int ret1[] = divisor(num + 1);
        System.out.println();
        int ret2[] = divisor(num + 2);

        if(Math.abs(ret1[0] - ret1[1]) < Math.abs(ret2[0] - ret2[1])) {
            return ret1;
        }else{
            return ret2;
        }
    }

    static int[] divisor(int num){
        int ret[] = new int[2];
        for (int i=1; i<= Math.sqrt(num); i++)
        {
            if(num%i == 0){
                if(num/i == i){
                    ret[0] = i;
                    ret[1] = i;
                    System.out.print(i + " ");
                    return ret;
                }else if( Math.abs(ret[0] - ret[1]) > Math.abs(i - (num/i))){
                    System.out.print( i + " " + num/i + " ");
                    ret[0] = i;
                    ret[1] = num/i;
                } else if(ret[0] == 0 && ret[1] == 0){
                    System.out.print( i + " " + num/i + " ");
                    ret[0] = i;
                    ret[1] = num/i;
                }
            }
        }
        return ret;
    }
}

//        Time Complexity : O(sqrt(n))
//        Auxiliary Space : O(1)