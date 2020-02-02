package com.string;

public class Reverse {

	public static void main(String[] args) {
		String testString = "This is test";
		
		int len = testString.length();
		StringBuilder sb = new StringBuilder();
		for (int i=len; i>0;i--){
			sb.append(testString.charAt(i-1));
		}
		System.out.println(sb);
	}
}
