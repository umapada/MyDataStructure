package com.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{ 
 
    class LogLine implements Comparable<LogLine>{
        String alphanumeric;
        String line;
 
        public LogLine(String alphanumeric, String line){
            this.alphanumeric = alphanumeric;
            this.line = line;
        }
 
        @Override
		public int compareTo(LogLine b) {
            if(this.line.equals(b.line)){   // if there is a tie
                return this.alphanumeric.compareTo(b.alphanumeric);
            }
            else{
                return this.line.compareTo(b.line);
            }
        }
 
    }
 
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> reorderLines(int logFileSize, List<String> logLines) 
	{
	    ArrayList <LogLine> wordsLines = new ArrayList<>();
 
		for(int i = 0; i < logLines.size(); i++){
		    if(isWordsLine(logLines.get(i))){
		        wordsLines.add( createLineObject(logLines.get(i)));
		    } 
		}
		// here we have all words lines then we sort
		Collections.sort(wordsLines);
 
		List<String> res = new ArrayList<>();
		for(int i = 0; i < wordsLines.size(); i++){
		    res.add(wordsLines.get(i).alphanumeric +" "+ wordsLines.get(i).line);
		}
 
		for(int i = 0; i < logLines.size(); i++){   // add numeric lines in order
		    if(!isWordsLine(logLines.get(i))){
		        res.add(logLines.get(i));
		    } 
		}
 
		return res;
	}
 
	public LogLine createLineObject(String line){
	    String words[] = line.split(" ");
 
        String alphanumeric = words[0];
        StringBuilder restOfLine = new StringBuilder();
 
        for(int i = 1; i < words.length; i++){
            restOfLine.append(words[i]);
            if(i < words.length -1){
                restOfLine.append(" ");
            }
        }
        return new LogLine(alphanumeric, restOfLine.toString());
	}
 
	public boolean isWordsLine(String line){
	    String words[] = line.split(" ");
 
	    if(words.length>1){
	        if(isInteger(words[1])){    // if the second word after alphanumeric is integer
	            return false;
	        }else{
	            return true;
	        }
	    }
	    return false;
	}
 
	public boolean isInteger(String word){
	    for(int i = 0; i < word.length(); i++){
	        if(word.charAt(i) > '9' || word.charAt(i) < '0'){
	            return false;
	        }
	    }
	    return true;
	}
 
}
