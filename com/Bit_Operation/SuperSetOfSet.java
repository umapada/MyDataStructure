package com.Bit_Operation;

/**
 * Print all superset of a set
 */
//Progress => //6
public class SuperSetOfSet {

	public static void main(String[] args) {
		char set[] = {'a', 'b', 'c'};
        printSubsets(set);

	}
	
	static void printSubsets(char set[])
    {
        int n = set.length;
 
        // Run a loop for printing all 2^n
        // subsets one by obe
        for (int i = 0; i < (1<<n); i++)
        {
            System.out.print("{");
 
            // Print current subset
            // (1<<j) is a number with jth bit 1 so when we 'and' them with the  subset number we get which numbers
            // are present in the subset and which are not
            for (int j = 0; j < n; j++)
            {
                if ((i & 1 << j) > 0) {
                    System.out.print(set[j] + " ");
                }
            }
 
            System.out.print("} ");
        }
    }
	
	

}
