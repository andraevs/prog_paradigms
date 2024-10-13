package sorting;

public class InsertionSort {

    public static void insertionSort(int[] array) {
        int n = array.length;

        // Start from the second element (index 1) because a single element is trivially sorted
        for (int i = 1; i < n; i++) {
            int key = array[i];  // Current element to be inserted
            int j = i - 1;

            // Shift elements of the sorted portion that are greater than the key
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            // Insert the current element (key) into its correct position
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        insertionSort(arr);
        System.out.println("\nSorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
