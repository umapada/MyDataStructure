package com.test.ds1.sort;
/*
Time Complexity: O(n2) as there are two nested loops.

Auxiliary Space: O(1)
The good thing about selection sort is it never makes more than O(n) swaps and can be useful when memory
write is a costly operation.
*/
public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = { 4, 6,2 , 1, 5, 34, 12, 3 , 2, 5} ;
		for(int a:arr){
			System.out.print (a + " - ");
		}
		
		for(int i=0; i < arr.length; i ++){
			int swap = i;
			for (int j=i; j < arr.length; j++){
				if (arr[swap] > arr[j]){
					swap = j;
				}
			}
			int temp = arr[swap];
			arr[swap] = arr[i];
			arr[i] = temp;

		}
		System.out.println();
		for(int a:arr){
			System.out.print (a + " - ");
		}

	}

}
