package data_structures.fibonacci;

import static data_structures.fibonacci.Fibonacci.count;
import static data_structures.fibonacci.Fibonacci.fasterCount;

public class FibonacciDemo {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println(fasterCount(44));
        long t2 = System.currentTimeMillis();
        System.out.println(count(44));
        long t3 = System.currentTimeMillis();
        System.out.println(fasterCount(42));
        long t4 = System.currentTimeMillis();
        System.out.println(count(42));
        long t5 = System.currentTimeMillis();

        System.out.println("fast version#1:" + (t2 - t1));
        System.out.println("slow version#1:" + (t3 - t2));
        System.out.println("fast version#2:" + (t4 - t3));
        System.out.println("slow version#2:" + (t5 - t4));
    }
}
