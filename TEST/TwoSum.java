package TEST;

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    private HashMap<Integer, Integer> map;

    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<Integer, Integer>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number,0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int complement = value - entry.getKey();
            if (complement != entry.getKey()) {
                if (map.containsKey(complement))
                    return true;
            } else {
                if (entry.getValue() > 1)
                    return true;
            }
        }
        return false;
    }
}
