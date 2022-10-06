package algorithms.sorting.bubblesort;

import algorithms.sorting.SortingAlgorithm;

public class BubbleSorting implements SortingAlgorithm {
    private static void swap(int[] array, int indexLeft) {
        int tmp = array[indexLeft];
        array[indexLeft] = array[indexLeft + 1];
        array[indexLeft + 1] = tmp;
    }

    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1])
                    swap(array, j);
            }
        }
    }
}
