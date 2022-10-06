package algorithms.sorting;

import java.util.Arrays;

public interface SortingAlgorithm {
    void sort(int[] array);

    default void sortAndPrint(int[] array) {
        this.sort(array);
        System.out.print(Arrays.toString(array));
    }
}
