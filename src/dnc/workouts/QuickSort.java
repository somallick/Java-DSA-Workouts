package src.dnc.workouts;


//https://www.geeksforgeeks.org/problems/quick-sort/1
public class QuickSort {

    public void quickSort(int[] arr, int start, int end) {
        //Base Case
        if (start >= end)
            return;

        //Partition
        int pivot = end;
        int i = start - 1;
        int j = start;
        while (j < pivot) {
            if (arr[j] < arr[pivot]) {
                i++;
                swap(arr, i, j);
            }
            j++;
        }
        i++;
        swap(arr, i, pivot);

        //Recursion for left & right partition elements
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
