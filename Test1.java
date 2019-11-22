import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Book{
    int bookId;
   public String bookName;

   public Book getBook(){
       return  new Book();
   }
}

public class Test1 {

    public static void main(String[] args) throws Exception {

        List<Book> repository = new ArrayList<>();

//        FactorialTask task = new FactorialTask(4);
//
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//        Future<Integer> future = executorService.submit(task);
//
//        System.out.println(future.get().intValue());

        OptionalInt sum = Arrays.stream(new int[]{1, 2, 3}).filter(i -> i >= 2).map(i -> i * 3).max();
        System.out.println(sum);
    }
}