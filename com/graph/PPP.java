package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.StringTokenizer;

public class PPP {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("and");
		list.add("he");
		list.add("the");
		list.add("to");
		list.add("is");
		list.add("Jack");
		list.add("Jill");
		
		List<String> mylist = retrieveMostFrequentlyUsedWords2("Jack and Jill went to the market to buy bread and cheese. cheese s Cheese is Jack's and Jill's favorite food",list);
		System.out.println(mylist);
	}

	static  List<String>   retrieveMostFrequentlyUsedWords2(String literatureText, List<String> wordsToExclude) {
//	List newlist = new ArrayList();
   ListIterator<String> iterator = wordsToExclude.listIterator();
   while (iterator.hasNext())
   {
       int test = 0;
      // newlist.add(iterator.next().toLowerCase());
       iterator.set(iterator.next().toLowerCase());
   }
	
	literatureText = literatureText.toLowerCase();
	literatureText = literatureText.replace("'", " " );
	literatureText = literatureText.replace(".", "" );
	Map<String, Integer> map = new HashMap<>();
	StringTokenizer str = new StringTokenizer(literatureText, " ");
	 while (str.hasMoreTokens()) {
		 String token = str.nextToken();
		 
	//	 boolean containsSearchStr = wordsToExclude.stream().filter(s -> s.equalsIgnoreCase(token)).findFirst().isPresent();
		 
		 if(!wordsToExclude.contains(token)) {
			 if(map.containsKey(token)) {
				int count = map.get(token);
				map.put(token, count+1);
			 }else {
				 map.put(token, 1);
			 }
			 
		 }
	 }
	 List<String> returnList = new ArrayList<>();
	 int max = -1;
	 for (Map.Entry<String,Integer> entry : map.entrySet()) {
           if(entry.getValue() > max) {
           	max = entry.getValue();
           }
	 }
	 
	 for (Map.Entry<String,Integer> entry : map.entrySet()) {
           if(entry.getValue() == max) {
           	returnList.add(entry.getKey());
           }
	 }
	 
	return returnList;
	// WRITE YOUR CODE HERE
}
	
	

	static List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude) {
		
	    ListIterator<String> iterator = wordsToExclude.listIterator();
	    while (iterator.hasNext())
	    {
	        iterator.set(iterator.next().toLowerCase());
	    }
		
		literatureText = literatureText.toLowerCase();
		literatureText = literatureText.replace("'", " " );
		literatureText = literatureText.replace(".", "" );
		Map<String, Integer> map = new HashMap<>();
		StringTokenizer str = new StringTokenizer(literatureText, " ");
		 while (str.hasMoreTokens()) {
			 String token = str.nextToken();
			 
			 boolean containsSearchStr = wordsToExclude.stream().filter(s -> s.equalsIgnoreCase(token)).findFirst().isPresent();
			 
			 if(!wordsToExclude.contains(token)) {
				 if(map.containsKey(token)) {
					int count = map.get(token);
					map.put(token, count+1);
				 }else {
					 map.put(token, 1);
				 }
				 
			 }
		 }
		 List<String> returnList = new ArrayList<>();
		 int max = -1;
		 for (Map.Entry<String,Integer> entry : map.entrySet()) {
	            if(entry.getValue() > max) {
	            	max = entry.getValue();
	            }
		 }
		 
		 for (Map.Entry<String,Integer> entry : map.entrySet()) {
	            if(entry.getValue() == max) {
	            	returnList.add(entry.getKey());
	            }
		 }
		 
		return returnList;
		// WRITE YOUR CODE HERE
	}

}
