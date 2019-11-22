import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PPP1 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A1", "A2", "B1", "B2", "C1", "C2", "C5", "c123", "c456");

      //  list.stream().map(String::toUpperCase).filter(s-> s.startsWith("C")).sorted().forEach(System.out::println);

     //   list.stream().findAny().ifPresent(System.out::println);

        list.stream().findAny().filter(s-> s.startsWith("A")).ifPresent(System.out::println);

        Stream.of("A","B","C").findAny().ifPresent(System.out::println);

        IntStream.of(2,4,6,1,7,2).average().ifPresent(System.out::println);
       OptionalDouble opt =  IntStream.range(2,20).average();

        System.out.println(opt.getAsDouble());

    }

}
