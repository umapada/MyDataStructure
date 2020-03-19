package extra;

import java.util.ArrayList;
import java.util.List;

/**
 * The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell
 * the stock so that in between those days your profit is maximum.
 *
 * Input:
 * First line contains number of test cases T. First line of each test case contains an integer value N denoting
 * the number of days, followed by an array of stock prices of N days.
 *
 * Output:
 * For each testcase, output all the days with profit in a single line. And if there is no profit then
 * print "No Profit".
 */
public class StockBySell {
     class Stock{
        int purchase;
        int sell;

        public String toString(){
            return purchase+ " " + sell;
        }
    }
    public static void main(String[] args) {
         int [] stk = {1, 3, 6, 7, 8, 2, 10};
       // int [] stk = {10, 9, 8, 7, 6, 5, 3};
        StockBySell test = new StockBySell();
        List<Stock> list = test.maxReturn(stk);


list.stream().forEach(System.out::println);    }

    List<Stock> maxReturn(int[] stck){
        List<Stock> list = new ArrayList<>();
        Stock stock = null;
        int len = stck.length;
        int left = 0;
        int right = 1;

        while(left < len - 1 && right < len){
            while (right < len - 1 &&  stck[right] < stck[right +1]){
                right ++;
            }
            if(left < right && stck[left] < stck[right]) {
                stock = new Stock();
                stock.purchase = stck[left];
                stock.sell = stck[right];
                list.add(stock);
            }
            left = right + 1;
            if(left < len - 2) {
                while ( left < len - 1 && stck[left] > stck [left + 1]) {
                    left ++;
                }
            }
            right = left + 1;
        }
        return list;
    }

}
