package com.array;

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

}
