package TEST;

import java.util.*;

//Implement least recently used cache
public class LRU {
    static int capacity = 2;
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();


     /*   putData(map,list, 2, 20);
        putData(map,list, 3, 30);
        putData(map,list, 4, 40);
        System.out.println(getData(map,list,2));
        putData(map,list, 5, 50);
        System.out.println(getData(map,list,5));
        System.out.println(getData(map,list,4));
        putData(map,list, 6, 60);
        System.out.println(getData(map,list,5));
        */
    }

  static  Integer getData(Map<Integer, Integer> map , LinkedList<Integer> list, Integer key){
        if(map.containsKey(key)){
            putData(map,list, key,map.get(key));
            return map.get(key);
        }else{
            return -1;
        }
    }

   static void putData(Map<Integer, Integer> map , LinkedList<Integer> list, Integer key, Integer value){
        if(map.size()>= capacity){
            if(!map.containsKey(key)) {
                Integer data = list.removeLast();
                map.remove(data);
                list.addFirst(key);
                map.put(key, value);
            }else{
                list.remove(key);
                list.addFirst(key);
            }
        }else{
            if(map.containsKey(key)) {
                list.remove(key);
                list.addFirst(key);
            }else{
                list.addFirst(key);
                map.put(key, value);
            }
        }
    }

}
