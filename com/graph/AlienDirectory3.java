package com.graph;

import java.util.*;

public class AlienDirectory3 {
}

class Solution {
    static Map<Character, List<Character>> charMap = new HashMap<>();
    static Map<Character, Boolean> visited = new HashMap<>();
    static Stack<Character> stack = new Stack<>();
    static Map<Character, Boolean> cycleCheck = new HashMap<>();
    static Map<Character, Boolean> cycleVisited = new HashMap<>();
    static boolean isCyclic = false;


    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"abc","ab"};
        System.out.println(s.alienOrder(words));
    }

    public String alienOrder(String[] words) {
        for(String word:words)
            for(char c:word.toCharArray()){
                charMap.putIfAbsent(c,new ArrayList<>());
            }

        for(int i=0; i < words.length - 1 ; i++){
            char[] first = words[i].toCharArray();
            char[] second = words[i+1].toCharArray();
            for(int j=0; j < Math.min(first.length, second.length); j++){
                if(first[j] != second[j]){
                //    charMap.putIfAbsent(first[j],new ArrayList<>());
                    charMap.get(first[j]).add(second[j]);
                    break;
                }
            }
        }

        Set<Character> mapSet = charMap.keySet();
        for(char c:mapSet){
            if(cycleCheck.get(c) == null || !cycleCheck.get(c)){
                isCyclic = isCyclicUtil(c);
                if(isCyclic) ;
                break;
            }
        }

        System.out.println(isCyclic);

        if(isCyclic){
            return "";
        }
        sort();

        StringBuilder sb = new StringBuilder();
        int n = stack.size();
        for(int i=0; i<n; i++){
            sb.append(stack.pop());
        }
        return sb.toString();
    }




    static void sort(){
        Set<Character> mapSet = charMap.keySet();
        for(char c: mapSet){
            if(visited.get(c) == null || !visited.get(c)){
                dfs(c);
            }
        }
    }

    static void dfs(Character c){
        List<Character> list = charMap.get(c);
        visited.put(c,true);
        for(char cr:list){
            if(visited.get(cr) == null || !visited.get(cr)){
                dfs(cr);
            }
        }
        stack.push(c);
    }

    private static boolean isCyclicUtil( char c)
    {

        if(cycleCheck.get(c) != null && cycleCheck.get(c)){
            return true;
        }

        if(cycleVisited.get(c) != null && cycleVisited.get(c)){
            return false;
        }

        cycleVisited.put(c,true);
        cycleCheck.put(c,true);
        List<Character> children = charMap.get(c);
        for (char cr: children) {
            if (isCyclicUtil(cr)) {
                return true;
            }
        }
        cycleCheck.put(c,false);
        return false;
    }
}