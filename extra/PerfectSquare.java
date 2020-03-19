package extra;

public class PerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(25));
    }

    public static boolean isPerfectSquare(int num) {
        int sum = 0;

        for (int i =1; sum <= num; i = i + 2){
            System.out.print(" " + sum);
            sum = sum + i;
            if(sum == num){
                return true;
            }
        }
        return false;
    }


    public static boolean isPerfectSquare2(int num) {

        double sr = Math.sqrt(num);
        System.out.println(sr);
        System.out.println(Math.floor(sr));
        // If square root is an integer
        return ((sr - Math.floor(sr)) == 0);
    }


}
