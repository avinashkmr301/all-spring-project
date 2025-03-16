package collection.map;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();

        map.put("avinash", 101);
        map.put("john", 102);
        map.put("brad", 103);
        map.put("paul", 104);
        map.put("shown", 105);

        System.out.println(map);

        Set<String> keySet = map.keySet();
        System.out.println("key: "+keySet);

        Collection<Integer> values = map.values();
        System.out.println("values: "+values);

        for (String key: keySet) {
            System.out.println("key: "+key+" "+ "value: "+map.get(key));
        }

    }
}
