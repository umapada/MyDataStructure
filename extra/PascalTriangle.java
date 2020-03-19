package extra;

//( O(n^2) time and O(1) extra space )
/*
This method is based on method 1. We know that ith entry in a line number line is
Binomial Coefficient C(line, i) and all lines start with value 1. The idea is to
calculate C(line, i) using C(line, i-1). It can be calculated in O(1) time using the following.

 */



public class PascalTriangle {

    //Diver code
    public static void main (String[] args) {
        int n = 10;
        printPascal(n);
    }

    //Pascal function
    public static void printPascal(int n)
    {
        for(int line = 1; line <= n; line++)
        {
            int C=1;// used to represent C(line, i)
            for(int i = 1; i <= line; i++)
            {
                // The first value in a line is always 1
                System.out.print(C+" ");
                C = C * (line - i) / i;
            }
            System.out.println(" ");
        }
    }
}
