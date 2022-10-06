package algorithms.sorting.mergesort;


public class MergeSort {
    private void merge(int[] array, int left, int middle, int right) {
        // Find sizes of two sub arrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        /* Create temp arrays */
        int[] L = new int[n1];
        int[] R = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[middle + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            }
            else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public void sort(int[] array, int left, int right) {
        if (left < right) {
            // Find the middle point
            int m = left + (right - left) / 2;

            // Sort first and second halves
            sort(array, left, m);
            sort(array, m + 1, right);

            // Merge the sorted halves
            merge(array, left, m, right);
        }
    }
}
