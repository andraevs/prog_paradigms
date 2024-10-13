package two_pointer;

import java.util.Random;

public class PartitionArray {
    public static void partitionArray(int[] arr, int pivot) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            // Move left pointer until you find an element greater than the pivot
            while (arr[left] < pivot) left++;
            // Move right pointer until you find an element smaller than the pivot
            while (arr[right] > pivot) right--;

            // Swap elements if necessary
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100); // Random numbers between 0 and 99
        }

        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        partitionArray(arr,30);
        System.out.println("modified array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
