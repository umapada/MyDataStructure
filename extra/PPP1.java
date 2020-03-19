package extra;

import java.util.*;
import java.util.stream.Collectors;


class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}


public class PPP1 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A1", "A2", "B1", "B2", "C1", "C2", "C5", "c123", "c456");

      //  list.stream().map(String::toUpperCase).filter(s-> s.startsWith("C")).sorted().forEach(System.out::println);

     //   list.stream().findAny().ifPresent(System.out::println);

//        list.stream().findAny().filter(s-> s.startsWith("A")).ifPresent(System.out::println);
//
//        Stream.of("A","B","C").findAny().ifPresent(System.out::println);
//
//        IntStream.of(2,4,6,1,7,2).average().ifPresent(System.out::println);
//       OptionalDouble opt =  IntStream.range(2,20).average();
//
//        System.out.println(opt.getAsDouble());
//
//        IntStream.range(1, 4).mapToObj(i -> "a" + i).forEach(System.out::print);

      //  Stream<String> str = Stream.of("d2", "a2", "b1", "b3", "c").filter(s-> s.startsWith("a"));

      //  str.forEach(System.out::println);



//        Stream.of("d2", "a2", "b1", "b3", "c")
//                .filter(s -> {
//                    System.out.println("filter: " + s);
//                    return s.startsWith("a");
//                })
//                .map(s -> {
//                    System.out.println("map: " + s);
//                    return s.toUpperCase();
//                })
//                .forEach(s -> System.out.println("****  forEach: " + s));

//        Stream<String>  stream = Stream.of("z1", "z5","z2","A1", "a2", "A3", "b1", "B2", "B3", "C1", "a2", "D1", "D5").filter(s-> s.startsWith("z")).map(s-> s.toUpperCase());
//
//        Supplier<Stream<String>> supplier = () -> Stream.of("z1", "z5","z2","A1", "a2", "A3", "b1", "B2", "B3", "C1", "a2", "D1", "D5").filter(s-> s.startsWith("z")).map(s-> s.toUpperCase());
//
//
//        supplier.get().forEach(System.out::println);
//        System.out.println("==============");
//
//        supplier.get().sorted().forEach(System.out::println);



        List<Person> personList = Arrays.asList(new Person("AAA", 12),new Person("AA", 12), new Person("BB", 15), new Person("CC", 20), new Person("DD", 35), new Person("CCC", 40));

        List<Person> filtered = personList.stream().filter(s-> s.name.startsWith("C")).collect(Collectors.toList());
//
//        Set<Person> setPerson = personList.stream().filter(s-> s.name.startsWith("A")).collect(Collectors.toSet());
//
//        System.out.println(filtered);
//        System.out.println(setPerson);
//
//        Map<Integer, List<Person>> mapPerson = personList.stream().collect(Collectors.groupingBy(s->s.age));
//
//
//        IntSummaryStatistics averageAge = personList.stream().collect(Collectors.summarizingInt(s->s.age));
//
//
//        System.out.println(averageAge);
//
//
//        String phrase = personList
//                .stream()
//                .filter(p -> p.age >= 41)
//                .map(p -> p.name)
//                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
//
//        System.out.println(phrase);
//
//        Map<Integer, String> map = personList
//                .stream()
//                .collect(Collectors.toMap(s->s.age,s->s.name, (name1,name2)->name1 +" " + name2));
//
//        System.out.println(map);

        Set<String> p2 =  personList
                .stream()
                .filter(p -> p.age >= 0)
                .map(a-> a.name)
                .collect(Collectors.toSet());

                System.out.println(p2);

    }

}
