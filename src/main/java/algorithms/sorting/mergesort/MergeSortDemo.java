package algorithms.sorting.mergesort;

import java.util.Arrays;

public class MergeSortDemo {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, -1, 0, 12, 15, 200};
        new MergeSort().sort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }
}
