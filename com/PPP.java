package com;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PPP {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);

        System.out.println (list.get(0));
        System.out.println (list.get(1));
        System.out.println (list.remove(1));
        System.out.println(list.size());
        System.out.println (list.get(0));



    }

}
