package com.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PalindromeInt {

	public static void main(String[] args) {
		
		int a = 123321;
		
		int t1 = a % 10;
		int t2 = a / 10;
		
		System.out.println(t1);
		
		System.out.println(t2);
		
		//System.out.println(a == reverse(a));
		
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		map.put("D", 4);
		
		Set<String> s = new HashSet<String>();
		
		Set<Entry<String, Integer>> set = map.entrySet();
		
		for(Entry<String, Integer> p:set){
			
			System.out.println(p.getKey());
		}
		//set.add("E=5");
		
		System.out.println(set);
		
System.out.println(map);
	}
	
	private static int reverse (int param){
		int reverese = 0;
		
		while(param != 0){
			reverese = reverese * 10 + param %10;
			param = param/10;
		}
		
		return reverese;
	}

}
