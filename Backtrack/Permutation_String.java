package Backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation_String {

   static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        String str = "aabb";
        int n = str.length();
        permute(str, 0, n-1);
        System.out.println(set);
    }
    static void permute(String str, int left, int right)
    {
        if (left == right)
            set.add(str);
        else
        {
            for (int i = left; i <= right; i++)
            {
                str = swap(str,left,i);
                permute(str, left+1, right);
                str = swap(str,left,i);
            }
        }
    }

    static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
