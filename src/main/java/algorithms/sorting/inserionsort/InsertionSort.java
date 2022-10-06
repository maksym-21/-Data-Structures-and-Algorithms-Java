package algorithms.sorting.inserionsort;

import algorithms.sorting.SortingAlgorithm;

public class InsertionSort implements SortingAlgorithm {
    /*
       Optimal for arrays, which are sorted or nearly sorted.
       In such cases - O(N)
     */

    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[0]) {
                int key = array[i];
                int j = i - 1;

                while (j >= 0 && array[j] > key) {
                    array[j + 1] = array[j];
                    j = j - 1;
                }
                array[j + 1] = key;
            }
        }
    }
}
