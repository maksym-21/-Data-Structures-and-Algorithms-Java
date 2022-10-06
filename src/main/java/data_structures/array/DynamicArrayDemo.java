package data_structures.array;

import java.util.Arrays;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray<String> array  = new DynamicArray<>(String.class);
        array.add("test");
        System.out.println(Arrays.toString(array.getArray()));
        System.out.println(array.length());
    }
}
