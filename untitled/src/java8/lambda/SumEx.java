package java8.lambda;



interface Sum{
    int add(int a, int b);
}
public class SumEx {
    public static void main(String[] args) {
        Sum s = (a,b) -> a+b;
         int result =s.add(4,5);
        System.out.println(result);

    }
}
