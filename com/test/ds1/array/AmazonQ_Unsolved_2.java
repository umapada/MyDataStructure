package com.test.ds1.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class AmazonQ_Unsolved_2 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.add("and");
		list.add("he");
		list.add("the");
		list.add("to");
		list.add("is");
		list.add("Jack");
		list.add("Jill");

		String str = "Jack and Jill went to the market to buy                      k          k    k		k            bread and cheese. cheese s Cheese is Jacks and Jills favorite food";
		List<String> mylist = retrieveMostFrequentlyUsedWords(str, list);
		System.out.println(mylist);
	}

	static List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude) {

		List<String> newList = new ArrayList<>();
		if (wordsToExclude != null)
			for (String str : wordsToExclude) {
				newList.add(str.toLowerCase());
			}

		wordsToExclude = newList;

		Map<String, Integer> map = new HashMap<>();
		if (literatureText != null) {
			literatureText = literatureText.toLowerCase();
			literatureText = literatureText.replace("'", " ");
			literatureText = literatureText.replace(".", "");
			literatureText = literatureText.replace("	", "");
			// }

			StringTokenizer str = new StringTokenizer(literatureText, " ");
			while (str.hasMoreTokens()) {
				String token = str.nextToken();
				if (!wordsToExclude.contains(token)) {
					if (map.containsKey(token)) {
						int count = map.get(token);
						map.put(token, count + 1);
					} else {
						map.put(token, 1);
					}

				}
			}
		}
		List<String> returnList = new ArrayList<>();
		int max = -1;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
			}
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max) {
				returnList.add(entry.getKey());
			}
		}

		return returnList;
		// WRITE YOUR CODE HERE
	}

}
