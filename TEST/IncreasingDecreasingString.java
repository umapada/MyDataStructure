package TEST;

public class IncreasingDecreasingString {


    public static void main(String[] args) {
        String input = "gggggggav";

        System.out.println(sortString(input));
    }

    public static String sortString(String s) {

        if(s==null || s.trim().length() == 0){
            return "";
        }

        StringBuffer out = new StringBuffer();
        int[] inputArray = new int [26];
        char[] inputChars = s.toCharArray();

        for (int i=0; i < inputChars.length; i ++){
            inputArray[inputChars[i] - 'a'] = inputArray[inputChars[i] - 'a']  + 1;
        }

        boolean leftToright = true;
        int count = 0;
           while(count< inputChars.length) {
               if (leftToright){
                   for (int i = 0; i < inputArray.length; i++) {
                       if (inputArray[i] != 0) {
                           out.append((char)(i + 'a'));
                           count++;
                           inputArray[i]--;
                       }

                   }
                   leftToright = false;
           }
               else{
                   for (int i = inputArray.length-1; i >=0; i--) {
                       if(inputArray[i] != 0){
                           out.append((char)(i + 'a'));
                           count++;
                           inputArray[i]--;
                       }

                   }
                   leftToright = true;
               }
        }

        return out.toString();
    }

}
