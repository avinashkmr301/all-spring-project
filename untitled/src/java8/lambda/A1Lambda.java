package java8.lambda;


interface A1{
    void test();

}

public class A1Lambda {
    public static void main(String[] args) {
        A1 a = ()-> System.out.println("Calling rest method from interface..");
        a.test();
    }
}
