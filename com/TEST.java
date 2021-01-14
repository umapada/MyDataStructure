package com;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;

class TEST{

    class Item{
        int s, e;
        Item(int s, int e){
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) {
        String s = "asbvdf";

        System.out.println( s.substring(1, s.length()-1) );



    }

    String[] solve(String[] S, int N){

        Map<String, Integer> map = new HashMap<>();

        for(String url:S){
            map.put(url, map.getOrDefault(url,0)+1);
        }

        List<String> keys = new ArrayList(map.keySet());

        Collections.sort(keys, (x,y) -> {
            int a = map.get(x);
            int b = map.get(y);
            if(a != b) return b-a;
            return x.compareTo(y);
        });

        if(N>keys.size()) N = keys.size();

        String ret [] = new String[N];
        int index = 0;

        while(index <N){
            ret[index] = keys.get(index);
            index++;
        }
        return ret;
    }
}