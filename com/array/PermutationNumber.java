package com.array;
//Progress => //6
public class PermutationNumber {

	public static void main(String args[]) {
		int[] sequence = { 1, 2, 3 };
		permute(sequence, 0);
	}

	static void permute(int[] a, int k) {
		if (k == a.length) {
			for (int p = 0; p < a.length; p++) {
				System.out.print(" [" + a[p] + "] ");
			}
			System.out.println();
		} else {
			for (int i = k; i < a.length; i++) {
				int temp = a[k];
				a[k] = a[i];
				a[i] = temp;

				permute(a, k + 1);

				temp = a[k];
				a[k] = a[i];
				a[i] = temp; 
			}
		}
	}
}
