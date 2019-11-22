import java.util.Map;
import java.util.TreeMap;

class Dog implements Comparable{
    String color;
    int size;
    Dog(String c, int s) {
        color = c;
        size = s;
    }
    public String toString(){
        return color + " dog" + size +" = ";
    }

    @Override
    public int compareTo(Object o) {
        Dog o1 = (Dog) o;
        return  o1.size - this.size;
    }
}

public class TestTreeMap {
    public static void main(String[] args) {
        Dog d1 = new Dog("red", 30);
        Dog d2 = new Dog("black", 20);
        Dog d3 = new Dog("white", 10);
        Dog d4 = new Dog("white2", 10);
        TreeMap treeMap = new TreeMap();
        treeMap.put(d1, 10);
        treeMap.put(d2, 15);
        treeMap.put(d3, 5);
        treeMap.put(d4, 20);
        treeMap.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}