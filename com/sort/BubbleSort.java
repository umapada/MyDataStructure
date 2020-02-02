package com.sort;
/*
Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.
Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
Auxiliary Space: O(1)
Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.
Sorting In Place: Yes
Stable: Yes
 */
public class BubbleSort {
	public static void main(String[] args) {
		int arr [] = {5,2,6,8,22,8,9};
		int len = arr.length;
		
		//System.out.println(arr);
		for(int x:arr){
			System.out.print(x + " ");
		}
		
		for(int i=0; i<len;i++){
			for (int j=0; j<i; j++){
				if(arr[i] < arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			
		}
		
		System.out.println();
		for(int x:arr){
			System.out.print(x + " ");
		}
		
	}

}
