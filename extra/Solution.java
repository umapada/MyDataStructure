package extra;

class Solution {

    public static void main(String[] args) {
       int [] ret =  closestDivisors(8);
        System.out.println(ret[0] + " " + ret[1]);
    }

    public static  int[] closestDivisors(int num) {

        int ret1[] = divisor(num+1);
        int ret2[] = divisor(num+2);

        if(Math.abs(ret1[0] - ret1[1]) < Math.abs(ret2[0] - ret2[1])) {
            return ret1;
        }else{
            return ret2;
        }


    }

    static int[] divisor(int n){

        int ret[] = new int[2];

        for (int i=1; i<=Math.sqrt(n); i++)
        {
            if(n%i == 0){
                if(n/i == i){
                    ret[0] = i;
                    ret[1] = i;
                    return ret;
                }else
                    if( Math.abs(ret[0] - ret[1]) > Math.abs(i - (n/i))){

                        ret[0] = i;
                        ret[1] = n/i;
                    } else{
                        ret[0] = i;
                        ret[1] = n/i;
                    }

            }
        }
        return ret;
    }

}