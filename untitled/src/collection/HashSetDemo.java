package collection;

import java.util.*;

public class HashSetDemo {
    public static void main(String[] args) {

        Random random = new Random();

        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 6; i++) {
            int i1 = random.nextInt(101);
            list.add(i1);
            System.out.println("i1: "+i1);
        }

        System.out.println("list: "+ list);

        Set<Integer> set = new TreeSet<>(list);
        System.out.println("collection.set: "+set);



    }
}
