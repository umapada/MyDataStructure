package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindFirstNonRepeatingChar {

    public static void main(String[] args) {
        String stream = "geeksforgeeks";

        List<Character> arrayList = new ArrayList<>();
        boolean [] isRepeated = new boolean[256];

       // Stream<Boolean> streamB = IntStream.range(0,isRepeated.length).mapToObj(x -> isRepeated[x]);

        for(int i=0; i < stream.length(); i++){
            Character c = stream.charAt(i);

            if(!isRepeated[c]){
                arrayList.add(c);
                isRepeated[c] = true;
            }else {
                arrayList.remove(c);
            }

            System.out.print( arrayList.get(0) + " ");
        }
        //streamB.forEach(x -> System.out.print(x + ":"));
    }

}
