package com.test.ds1.array;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class PPPP {

	public static void main(String[] args) {
		List<String> logLines = new ArrayList<>();
		logLines.add("a1 9 2 3 1");
		logLines.add("g1 act car");
		logLines.add("zo4 4 7");
		logLines.add("ab1 off key dog");
		logLines.add("a8 act zoo");

		List<String> myList = reorderLines(5, logLines);
		
		System.out.println(myList);
		
		for(String str:myList ) {
			System.out.println(str);
		}

	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static List<String> reorderLines(int logFileSize, List<String> logLines) {
		List<String> returnList = new ArrayList<>();
		List<String> validList = new ArrayList<>();
		List<String> invalidList = new ArrayList<>();
		Map<String, String> map = new TreeMap<>();

		Iterator<String> itr = logLines.iterator();
		while (itr.hasNext()) {
			String line = itr.next();

			StringTokenizer str = new StringTokenizer(line, " ");
			boolean number = false;

			while (str.hasMoreTokens()) {
				String token = str.nextToken();

				if (isNumeric(token)) {
					invalidList.add(line);
					number = true;
					break;
				}
			}
			if (!number) {

				String[] arr = line.split(" ", 2);
				
				if(map.get(arr[1])  != null) {
					map.put(arr[1] +"*", line);
				}else {
					map.put(arr[1], line);
				}
			}

		}

		for (Map.Entry<String, String> entry : map.entrySet()) {
			validList.add(entry.getValue());
		}

		returnList.addAll(validList);
		returnList.addAll(invalidList);

		return returnList;
		// WRITE YOUR CODE HERE
	}

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional '-' and decimal.
	}

}
