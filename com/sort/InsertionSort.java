package com.sort;

/*
 * Time Complexity: O(n*n)

Auxiliary Space: O(1)

Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order.
And it takes minimum time (Order of n) when elements are already sorted.

Algorithmic Paradigm: Incremental Approach

Sorting In Place: Yes

Stable: Yes

Online: Yes

Uses: Insertion sort is used when number of elements is small. It can also be useful when input array is almost sorted,
only few elements are misplaced in complete big array.

What is Binary Insertion Sort?
We can use binary search to reduce the number of comparisons in normal insertion sort. Binary Insertion Sort find use
binary search to find the proper location to insert the selected item at each iteration. In normal insertion, sort it
takes O(i) (at ith iteration) in worst case. we can reduce it to O(logi) by using binary search. The algorithm as a
whole still has a running worst case running time of O(n2) because of the series of swaps required for each insertion.
Refer this for implementation.
 * 
 */

public class InsertionSort {

	public static void main(String[] args) {

		int arr[] = { 3, 5, 1, 8, 6, 2 };
		for (int a : arr) {
			System.out.print(a + " - ");
		}

		for (int i = 1; i < arr.length; ++i) {
			int key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one
			 * position ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}

		System.out.println();
		for (int a : arr) {
			System.out.print(a + " - ");
		}

	}

}
