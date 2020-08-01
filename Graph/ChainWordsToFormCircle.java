package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of strings, find if the given strings can be chained to form a circle. A string X can be put
 * before another string Y in circle if the last character of X is same as first character of Y.
 * <p>
 * Examples:
 * <p>
 * Input: arr[] = {"geek", "king"}
 * Output: Yes, the given strings can be chained.
 * Note that the last character of first string is same
 * as first character of second string and vice versa is
 * also true.
 * <p>
 * Input: arr[] = {"for", "geek", "rig", "kaf"}
 * Output: Yes, the given strings can be chained.
 * The strings can be chained as "for", "rig", "geek"
 * and "kaf"
 * <p>
 * Input: arr[] = {"aab", "bac", "aaa", "cda"}
 * Output: Yes, the given strings can be chained.
 * The strings can be chained as "aaa", "aab", "bac"
 * and "cda"
 * <p>
 * Input: arr[] = {"aaa", "bbb", "baa", "aab"};
 * Output: Yes, the given strings can be chained.
 * The strings can be chained as "aaa", "aab", "bbb"
 * and "baa"
 * <p>
 * Input: arr[] = {"aaa"};
 * Output: Yes
 * <p>
 * Input: arr[] = {"aaa", "bbb"};
 * Output: No
 * <p>
 * Input  : arr[] = ["abc", "efg", "cde", "ghi", "ija"]
 * Output : Yes
 * These strings can be reordered as, “abc”, “cde”, “efg”,
 * “ghi”, “ija”
 * <p>
 * Input : arr[] = [“ijk”, “kji”, “abc”, “cba”]
 * Output : No
 */

//Important
//Progress => //4
public class ChainWordsToFormCircle {


    public static void main(String args[]) {
        //   String chainInput[] = {"geeks","king", "seeks", "sing","gik","kin"};
        String chainInput[] = {"king", "gik", "geeks", "seeks", "sing"};
        ChainWordsToFormCircle cwt = new ChainWordsToFormCircle();
        List<String> result = cwt.formCircle(chainInput);
        if (result.size() == 0) {
            System.out.println("Not able to form a chain");
        } else {
            for (String chainNode : result) {
                System.out.print(chainNode + " ");
            }
        }
    }

    public List<String> formCircle(String input[]) {
        List<String> result = new ArrayList<String>();
        //since chain is a circle any point can be the start point of the chain.
        //We make input[0] as start point
        result.add(input[0]);
        boolean used[] = new boolean[input.length];
        boolean r = formCircle(input, result, used);
        if (!r) {
            return Collections.emptyList();
        }
        return result;
    }

    //we keep track of first char of the chain and the end compare that with last char of last element of the chain
    private boolean formCircle(String input[], List<String> result, boolean used[]) {
        if (input.length == result.size()) {
            String str = result.get(result.size() - 1);
            if (result.get(0).charAt(0) == str.charAt(str.length() - 1)) {
                return true;
            }
            return false;
        }
        String str = result.get(result.size() - 1);
        char lastChar = str.charAt(str.length() - 1);
        for (int i = 1; i < input.length; i++) {
            if (!used[i]) {
                if (lastChar == input[i].charAt(0)) {
                    used[i] = true;
                    result.add(input[i]);
                    boolean r = formCircle(input, result, used);
                    if (r) {
                        return true;
                    }
                    used[i] = false;
                    result.remove(result.size() - 1);
                }
            }
        }
        return false;
    }
}
