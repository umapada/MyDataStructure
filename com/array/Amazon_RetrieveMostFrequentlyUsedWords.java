package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Amazon_RetrieveMostFrequentlyUsedWords {

	public static void main(String[] args) {
		String literatureText = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack  favorate food.";

		List<String> exc = new ArrayList<String>();
		exc.add("and");
		exc.add("he");
		exc.add("the");
		exc.add("to");
		exc.add("is");
		//exc.add("Jack");
		//exc.add("Jill");

		System.out.println(retrieveMostFrequentlyUsedWords(literatureText, exc));

	}

	public static List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude) {

		wordsToExclude.replaceAll(String::toLowerCase);

		literatureText = literatureText.replace("'", " ").replace(".", "").toLowerCase();
		String a[] = literatureText.split("\\s+");
		List<String> alist = Arrays.asList(a);
		List<String> b = alist.stream().filter(s -> !wordsToExclude.contains(s)).collect(Collectors.toList());

		Map<String, Integer> collect = b.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));

		// Map<String, Long> collect1 =
		// b.stream().collect(Collectors.groupingBy(Function.identity(),
		// Collectors.counting()));

		Map<String, Integer> countByWordSorted = collect.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> {
					throw new IllegalStateException();
				}, LinkedHashMap::new));

		// countByWordSorted.get
		List<String> toplist = new ArrayList<>();
		int max = countByWordSorted.entrySet().iterator().next().getValue();
		countByWordSorted.forEach((k, v) -> {

			if (max == v) {
				toplist.add(k);
			}

		});
		return toplist;
	}

}
