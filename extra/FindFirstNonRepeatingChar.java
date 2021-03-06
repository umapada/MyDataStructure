package extra;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the first non-repeating character from a stream of characters
 * Given a stream of characters, find the first non-repeating character from stream. You need to tell the first
 * non-repeating character in O(1) time at any moment. If we follow the first approach discussed here, then we
 * need to store the stream so that we can traverse it one more time to find the first non-repeating character
 * at any moment. If we use extended approach discussed in the same post, we need to go through the count array
 * every time first non-repeating element is queried. We can find the first non-repeating character from stream
 * at any moment without traversing any array.
 */


public class FindFirstNonRepeatingChar {

    public static void main(String[] args) {
        String stream = "geeksforgeeks";

        List<Character> arrayList = new ArrayList<>();
        boolean [] isRepeated = new boolean[256];

       // Stream<Boolean> streamB = IntStream.range(0,isRepeated.length).mapToObj(x -> isRepeated[x]);

        for(int i=0; i < stream.length(); i++){
            Character c = stream.charAt(i);

            if(!isRepeated[c]){
                arrayList.add(c);
                isRepeated[c] = true;
            }else {
                arrayList.remove(c);
            }

            System.out.print( arrayList.get(0) + " ");
        }
        //streamB.forEach(x -> System.out.print(x + ":"));
    }

}
