package algorithms.sorting.selectionsort;

import algorithms.sorting.SortingAlgorithm;

public class SelectionSort implements SortingAlgorithm {
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int tmpMinValue = array[i];
            int tmpValue = tmpMinValue;
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < tmpValue) {
                    minIndex = j;
                    tmpValue = array[j];
                }
            }
            array[i] = array[minIndex];
            array[minIndex] = tmpMinValue;
        }
    }
}
