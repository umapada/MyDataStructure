package Cmpny.Extra;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Guidewire2 {

    public static void main(String[] args) throws Exception{
        String S = "Mon 01:00-23:00\nTue 01:00-23:00\nWed 01:00-23:00\nThu 01:00-23:00\nFri 01:00-23:00\nSat 01:00-23:00\nSun 01:00-21:00";
        //
        // System.out.println(solution(S));

        String a = "235";

    }

    public static int solution(String S) {
        int ret = 0;
        // write your code in Java SE 8
        int maxTime = 0;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String end = "";
        String start = "";
        try {

            String str[] = S.split("\n");

            for (int i = 0; i < str.length; i = i + 2) {

                start = str[i].substring(10, 15);
                if(i+1 < str.length) {
                     end = str[i + 1].substring(4, 9);
                }else{
                    // end = str[0].substring(4, 9);
                }

                Date date1 = format.parse(start);

                Date date2 = format.parse(end);

                long difference = date2.getTime() - date1.getTime();

                int minutes = (int) TimeUnit.MILLISECONDS.toMinutes(difference);

                if(minutes<0)minutes += 1440;

                if(minutes > maxTime){
                    maxTime = minutes;
                }
                 end = "00:00";
                 start = "00:00";

            }

        }catch (Exception ex){
            ex.printStackTrace();
            return 0;
        }
        return  maxTime;
    }


}
