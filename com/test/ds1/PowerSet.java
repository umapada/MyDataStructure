package com.test.ds1;

// Given a set s = {1, 2, 3};
// Write a function to return its powerset ss = {{}, {1}, {2}, {3}, {1,2}, {2,3}, {1,3}, {1,2,3}};

import java.util.HashSet;
import java.util.Set;

public class PowerSet {

    public static void main(String args[]) {
        HashSet<Integer> s = new HashSet<Integer>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(5);
        System.out.println(superset(s).size());
    }

    public static HashSet<HashSet> superset(Set<Integer> set) {

        HashSet<HashSet> retSet = new HashSet<>();

        Object[] arr = set.toArray();

        long numberOfElements = (long)Math.pow(2,set.size());

        for (int i=0; i < numberOfElements; i++){

            HashSet<Integer> tempSet = new HashSet<>();

            for(int j=0; j< set.size(); j++){

                if((i & ( 1 << j)) > 0){
                    tempSet.add((int)arr[j]);
                }
            }
            retSet.add(tempSet);
        }

        return retSet;
    }
}
