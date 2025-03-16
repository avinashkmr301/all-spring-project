package collection.map;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new IdentityHashMap<>();


        map.put(10,"avi");
        map.put(10,"jan");

        System.out.println(map);
    }
}
