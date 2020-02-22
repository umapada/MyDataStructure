package extra;

import java.util.ArrayList;
import java.util.List;

public class PPP {


    // Driver Code
    public static void main(String args[])
    {
        String str = "abcd";
        System.out.println(pal(str));
    }


    static String pal(String s){
        int n = s.length();
        String rev =  new StringBuffer(s).reverse().toString();

        int j = 0;
        for (int i = 0; i < n; i++) {

            String p = s.substring(0, n - i);
            String pp = rev.substring(i);
            System.out.println(s);
            if (p.equals(pp))
                return rev.substring(0, i) + s;
        }
        return "";
    }

}
