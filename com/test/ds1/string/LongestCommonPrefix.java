package com.test.ds1.string;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix {


    public static void main(String[] args) {
        String str[] = {"abca","aba","aaab"};
        System.out.println(longestCommonPrefix(str));
    }


    public static String longestCommonPrefix(String[] strs) {
        String ret = "";
        int strPos = -1;
        Set<Character> set = new HashSet();
        boolean found = true;
        if(strs != null && strs.length > 0)
            while(found) {
                set.clear();
            strPos ++;
            for (int i = 0; i < strs.length; i++) {

                if (strs[i].length() > strPos) {
                    if(i == 0){
                        set.add(strs[i].charAt(strPos));
                        ret = ret + strs[i].charAt(strPos);
                    }
                    else {
                        if(!set.contains(strs[i].charAt(strPos))){
                            found = false;
                            if( strs.length > 1 && ret.length()>0) {
                                ret = ret.substring(0, ret.length() - 1);
                            }
                            break;
                        }
                    }
                }else {
                    found = false;
                    if(i != 0 && strs.length > 1 && ret.length()>0) {
                        ret = ret.substring(0, ret.length() - 1);
                    }
                    break;
                }
            }
        }
        return ret;
    }
}
