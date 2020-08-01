package TEST;

//00000010100101000001111010011100
import java.util.*;

class TEST {
    static int count = 0;
    int i = Integer.MIN_VALUE;

    public static void main(String[] nums) {
      String s = "   +0 123";
      s = s.replaceAll("\\s", "");

        System.out.println(s);


    }

    public boolean wordBreak(String s, List<String> wordDict) {
        //Input: s = "leetcode", wordDict = ["leet", "code"]
        //Output: true
        boolean [] b = new boolean[s.length()+1];
        b[0] = true;
        for(int i=0; i<=s.length(); i++){
            for(int j=0; j< i; j++){
                String st = s.substring(j,i);
                if(b[j] && wordDict.contains(s.substring(j,i))){
                    b[i] = true;
                }
            }
        }
        return b[s.length()];
    }
}






