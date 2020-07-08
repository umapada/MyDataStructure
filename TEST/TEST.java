package TEST;


import java.util.*;

class TEST {
    static int count = 0;
    int i = Integer.MIN_VALUE;

    public static void main(String[] nums) {

        LinkedList<Integer> list = new LinkedList<>();

        PriorityQueue<Integer> Q = new PriorityQueue<>();

        long l = new Date().getTime();

        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";

        paragraph =  paragraph.replace(',',' ');
        paragraph =  paragraph.replace('.',' ');

        List<Integer> ll = new ArrayList<>();




        String[] spl = paragraph.split(" ");
        char[] chr = paragraph.toCharArray();
        for(String str:spl){
            System.out.println(str);
        }
    }
}






