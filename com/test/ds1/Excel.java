package com.test.ds1;

public class Excel {

	public static void main(String[] args) {
		System.out.println(toName(123));
		System.out.println(toNumber("CV"));
	}

	public static int toNumber(String column) {
		int result = 0;
		for (int i = 0; i < column.length(); i++) {
			result =  result * 26;
			int j = column.charAt(i) - ('A' - 1); 
			result = result + j;
		}
		return result;
	}

	public static String toName(int number) {
		final StringBuilder sb = new StringBuilder();

		int num = number - 1;
		while (num >= 0) {
			int numChar = (num % 26) + 65;
			sb.append((char) numChar);
			num = (num / 26) - 1;
		}
		return sb.reverse().toString();
	}

}
