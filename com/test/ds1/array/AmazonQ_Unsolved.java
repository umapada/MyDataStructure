package com.test.ds1.array;

//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//CLASS BEGINS, THIS CLASS IS REQUIRED
public class AmazonQ_Unsolved {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	static List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude) {
		if (literatureText == null || literatureText.length() == 0) {

			return null;

		}

		int max = -1;

		List<String> resList = new ArrayList<>();

		Map<String, Integer> map = new HashMap<>();

		int i = 0;

		while (i < literatureText.length()) {

			StringBuilder sb = new StringBuilder();

			while (!isPunctuation(literatureText.charAt(i)) && i < literatureText.length()) {

				sb.append(literatureText.charAt(i));

				i++;

			}

			if (sb.length() != 0) {

				String word = sb.toString().toLowerCase();

				boolean isExclude = false;

				for (int j = 0; j < wordsToExclude.size(); j++) {

					if (wordsToExclude.get(j).equalsIgnoreCase(word)) {

						isExclude = true;

						break;

					}

				}

				if (!isExclude) {

					int occur = 1;

					if (map.containsKey(word)) {

						occur = map.get(word) + 1;

						map.put(word, occur);

					}

					else {

						map.put(word, 1);

					}

					if (occur == max) {

						resList.add(word);

					}

					else if (occur > max) {

						resList.clear();

						resList.add(word);

						max = occur;

					}

				}

			}

			i++;

		}

		return resList;
	}
	// METHOD SIGNATURE ENDS

	public static boolean isPunctuation(char c) {

		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {

			return false;

		}

		return true;

	}
	
	
	public static void main(String ...strings) {
List<String> list = new ArrayList<>();
		
		list.add("and");
		list.add("he");
		list.add("the");
		list.add("to");
		list.add("is");
		list.add("Jack");
		list.add("Jill");
		
		List<String> mylist = retrieveMostFrequentlyUsedWords("Jack and Jill went to the market to buy bread and cheese. cheese s Cheese is Jacks and Jills favorite food",list);
		System.out.println(mylist);
	}

}
