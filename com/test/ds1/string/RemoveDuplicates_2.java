package com.test.ds1.string;

import java.util.Arrays;

public class RemoveDuplicates_2 {

	public static void main(String[] args) {
		
		String str= "This is test";

		System.out.println(removeDuplicate(str.toCharArray()));

	}

	static String removeDuplicate(char str[]) {
		// Used as index in the modified string
		int index = 0;
		int n = str.length;
		// Traverse through all characters
		for (int i = 0; i < n; i++)
		{
			// Check if str[i] is present before it
			int j;
			for (j = 0; j < i; j++)
			{
				if (str[i] == str[j])
				{
					System.out.println(str[i]);
					break;
				}
			}
			// If not present, then add it to result.
			if (j == i)
			{
				str[index++] = str[i];
			}
		}
		return String.valueOf(Arrays.copyOf(str, index));
	}

}
