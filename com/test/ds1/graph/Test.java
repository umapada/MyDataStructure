package com.test.ds1.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ND {
	int data;
	ND left, right;

	ND(int data) {
		this.data = data;
		left = null;
		right = null;
	}

}

public class Test {

	ND root = null;
	StringBuilder sb = new StringBuilder();
	static int[] A = new int[3];

	public static void main2(String[] args) {

		binary(3);

	}

	public static void main(String[] args) {

		//System.out.println(findSubStringwithOneRepeat("sameerkumar", 4));

		//int [] arr = {1,2,2,2,4,2,1,2,2,6,7,8,2,2,5,3};
		
		//System.out.println(findMajCandidate(arr));
		

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("java", 20);
        map.put("C++", 45);
        map.put("Java2Novice", 2);
        map.put("Unix", 67);
        map.put("MAC", 26);
        map.put("Why this kolavari", 93);
        Set<Entry<String, Integer>> set = map.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Entry<String, Integer>>()
        {
            public int compare( Entry<String, Integer> o1, Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        int count=0;
       // for(Map.Entry<String, Integer> entry:list){
            //System.out.println(entry.getKey()+" ==== "+entry.getValue());
      //  }
       // System.out.println(list.size());
        for(int i=0; i<2; i++) {
        	System.out.println(list.get(i));
        }	
	}

	public static int findMajCandidate(int[] arr) {
		if (arr == null || arr.length == 0) {
			return Integer.MIN_VALUE;
		}
		int count = 1, maj = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == maj) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				maj = arr[i];
				count = 1;
			}
		}
		System.out.println(count);
		return maj;
	}

	public static String findSubStringwithOneRepeat(String input, int k) {
		char[] inputArray = input.toCharArray();
		char[] retString = null;
		Set<Character> set = new HashSet<>();
		int repeatCount = 0;
		boolean isAdded = false;

		for (int i = 0; i < input.length() - k; i++) {
			retString = new char[k];
			isAdded = false;
			set.clear();
			for (int j = 0; j < k; j++) {
				retString[j] = inputArray[i + j];
				isAdded = set.add(retString[j]);
				System.out.println(String.valueOf(retString));
				if (!isAdded) {
					repeatCount++;
				}
			}
			if (repeatCount == 1) {
				break;
			}

		}

		return String.valueOf(retString);
	}

	static void binary(int n) {
		if (n < 1) {
			for (int a : A) {
				System.out.print(a);
			}
			System.out.print("-");
		} else {
			A[n - 1] = 0;
			binary(n - 1);
			A[n - 1] = 1;
			binary(n - 1);

		}

	}

	public static void main1(String[] args) {
		Test tt = new Test();
		ND nd = new ND(100);
		tt.root = nd;
		tt.root.left = new ND(9);
		tt.root.right = new ND(7);

		tt.root.left.left = new ND(11);
		tt.root.left.right = new ND(12);

		tt.root.left.left.left = new ND(3);
		tt.root.left.left.right = new ND(2);

		tt.root.left.right.right = new ND(4);

		tt.root.right.left = new ND(6);
		tt.root.right.right = new ND(5);

		tt.root.right.right.left = new ND(2);
		tt.root.right.right.right = new ND(1);

		tt.inorder(tt.root);
		System.out.println(tt.sb);

		String[] strArr = tt.sb.toString().split(",");

		for (String str : strArr) {
			System.out.println(str);
		}
		System.out.println(strArr);
	}

	private void inorder(ND node) {

		if (node == null) {
			sb.append("null,");
			return;
		}
		// System.out.print (node.data + " -> ");
		sb.append(node.data + ",");
		inorder(node.left);
		inorder(node.right);
	}

	public static String reverseRecursively(String str) {

		// base case to handle one char string and empty string
		if (str.length() < 2) {
			return str;
		}

		return reverseRecursively(str.substring(1)) + str.charAt(0);

	}

}
