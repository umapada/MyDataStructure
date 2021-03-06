package com.array;

//Progress => //2*/
public class ArrayRotation {

	public static void main(String[] args) {
		int arr[] = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		print(arr);
		leftRotate(arr);
		leftRotate(arr);
		leftRotate(arr);
		print(arr);

	}

	private static void leftRotate(int[] arr) {
		int temp=arr[0];
		for(int i=0; i< arr.length-1; i++ ) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1] = temp;
	}
	
	private static void  print(int arr[]) {
		for(int a:arr) {
			System.out.print(a  +" - ");
		}
		System.out.println();
	}



	/**
	 * This is an extension of method 2. Instead of moving one by one, divide the array in different sets
	 * where number of sets is equal to GCD of n and d and move the elements within sets.
	 * If GCD is 1 as is for the above example array (n = 7 and d =2), then elements will be moved within one set only,
	 * we just start with temp = arr[0] and keep moving arr[I+d] to arr[I] and finally store temp at the right place.
	 *
	 * Here is an example for n =12 and d = 3. GCD is 3 and
	 *
	 *
	 * Let arr[] be {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}
	 *
	 * a) Elements are first moved in first set – (See below
	 *    diagram for this movement)
	 *
	 * ArrayRotation
	 *
	 *           arr[] after this step --> {4 2 3 7 5 6 10 8 9 1 11 12}
	 *
	 * b)    Then in second set.
	 *           arr[] after this step --> {4 5 3 7 8 6 10 11 9 1 2 12}
	 *
	 * c)    Finally in third set.
	 *           arr[] after this step --> {4 5 6 7 8 9 10 11 12 1 2 3}
	 */


	/*Function to left rotate arr[] of siz n by d*/
	void leftRotate(int arr[], int d, int n)
	{
		int i, j, k, temp;
		int g_c_d = gcd(d, n);
		for (i = 0; i < g_c_d; i++) {
			/* move i-th values of blocks */
			temp = arr[i];
			j = i;
			while (true) {
				k = j + d;
				if (k >= n)
					k = k - n;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
	}

	/*UTILITY FUNCTIONS*/

	/* function to print an array */
	void printArray(int arr[], int size)
	{
		int i;
		for (i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
	}

	/*Fuction to get gcd of a and b*/
	int gcd(int a, int b)
	{
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}


}
