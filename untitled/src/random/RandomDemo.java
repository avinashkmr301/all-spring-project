package random;

import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt();
        System.out.println("i: "+i);

        int i1 = random.nextInt(10);
        System.out.println("i1: "+i1);

    }
}
