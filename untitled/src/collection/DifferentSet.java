package collection;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class DifferentSet {
    public static void main(String[] args) {
        Random random = new Random();

        //Set<Integer> collection.set = new HashSet<Integer>();
        Set<Integer> set = new LinkedHashSet<>();

        for (int i = 0; i < 10; i++) {
            int i1 = random.nextInt(109);
            set.add(i1);
            System.out.print(i1+" ");
        }
        System.out.println();
        //System.out.println("HashSet: " + collection.set);
        System.out.println("LinkedHashSet: " + set);
    }
}
