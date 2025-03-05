package src.sort.workouts;

import src.utility.PrintArray;

//https://www.geeksforgeeks.org/problems/bubble-sort/1
public class BubbleSort {
    public static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 4, 1, 7, 0};
        sort(arr);
        PrintArray.printArray(arr);
    }
}
