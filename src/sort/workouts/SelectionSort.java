package src.sort.workouts;

//https://www.geeksforgeeks.org/problems/selection-sort/1
public class SelectionSort {
    public static void sort(int[] arr) {
        // code here
        int minIndex = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            minIndex = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
