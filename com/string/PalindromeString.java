package com.string;

public class PalindromeString {

	public static void main(String[] args) {
		String pal = "aba";
		boolean palindrome = true;
		char arr[] = pal.toCharArray();
		int j = pal.length();
		for (int i = 0; i < pal.length(); i++) {
			j--;
			if (i > j) {
				break;
			}
			System.out.println(pal.substring(i, i+1));
			System.out.println(pal.substring(j, j+1));
			if (arr[i] != arr[j]) {  //arr[i] != arr[j]
				palindrome = false;
				break;
			}
		}
		System.out.println(palindrome);
	}

}
