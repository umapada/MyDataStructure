package com.test.ds1.Bit_Operation;

/**
 * Print all superset of a set
 */
public class SuperSetOfSet {

	public static void main(String[] args) {
		char set[] = {'a', 'b', 'c'};
        printSubsets(set);
        
        int a1[] = new int [5];
        
        int size = a1.length;
        int b1[] = new int [size];
        
        System.out.println(b1.length);
        
        //System.out.println(1<<3);
        
       // int x = 64;
       // System.out.println(16>>>3); 

	}
	
	static void printSubsets(char set[])
    {
        int n = set.length;
 
        // Run a loop for printing all 2^n
        // subsets one by obe
        for (int i = 0; i < (1<<n); i++)
        {
            System.out.print("{ ");
 
            // Print current subset
            for (int j = 0; j < n; j++)
 
                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
            {
            	int k = 1 << j;
                if ((i & k) > 0)
                    System.out.print(set[j] + " ");
            }
 
            System.out.println("}");
        }
    }
	
	

}
