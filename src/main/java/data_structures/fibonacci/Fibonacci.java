package data_structures.fibonacci;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public static long count(long number) {
        // O(2^n) - wow, not really good solution..

        if (number <= 0) return 0;
        if (number == 1) return 1;
        return count(number - 1) + count(number - 2);
    }

    public static long fasterCount(int number) {
        // better scalable solution! Now it takes O(n)

        if (number <= 0) return 0;
        List<Long> array = new ArrayList<>();
        array.add(0L);
        array.add(1L);
        for (int i = 2; i <= number; i++) {
            array.add(array.get(i - 1) + array.get(i - 2));
        }
        return array.get(number - 1);
    }
}
