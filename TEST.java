import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class TEST {
    private List<String> names;

    public static void main(String[] args) throws  Exception{
//        Optional<String> empty = Optional.ofNullable(null);
//
//        System.out.println(empty.isPresent());
//        if(empty.isPresent()) {
//            System.out.println(empty.get());
//        }
//
//        String test = "Hello";
//        empty = Optional.of(test);
//        empty.ifPresent( name -> System.out.println(name));
//
//        Future<Integer> future = new SquareCalculator().calculate(10);
//
//        while(!future.isDone()) {
//            System.out.println("Calculating...");
//            Thread.sleep(300);
//        }
//        System.out.println("Done - 1");
//        Integer result = future.get();
//        System.out.println("Done - 2");
//        System.out.println(result);

        List<String> list = new ArrayList<>();
        list.add("hello 1");
        list.add("hello 2");
        list.add("hello 3");
        list.add("hello 4");

        list.forEach(a -> System.out.println(a));

        List<Integer> number = Arrays.asList(2,3,4,5);
        List square = (List) number.stream().map(x -> x*x).collect(Collectors.toList());
        System.out.println(square);

        List<String> names = names;
        List result = names.stream().filter(s->s.startsWith("R")).collect(Collectors.toList());
        System.out.println(result);

        List result1 = names.stream().sorted().collect(Collectors.toList());
        System.out.println(result1);

        System.out.println(Thread.holdsLock(result1));
        Thread.holdsLock(result1);

    }
}

class SquareCalculator {

   private ExecutorService executor
           = Executors.newSingleThreadExecutor();

   public Future<Integer> calculate(Integer input) {
       return executor.submit(() -> {
           Thread.sleep(1000);
           return input * input;
       });
   }
}