package collection.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<StringBuffer> set = new TreeSet<>();

        set.add(new StringBuffer("abc"));
        set.add(new StringBuffer("mno"));
        set.add(new StringBuffer("xyz"));
        set.add(new StringBuffer("pqr"));
        set.add(new StringBuffer("uv"));

        for (StringBuffer s:set) {
            System.out.println(s);
        }




    }
}
