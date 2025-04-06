package src.arrays.workouts;

// https://www.geeksforgeeks.org/reverse-an-array-in-java/
public class ArrayReverse {

    public static void reverseArray(int[] arr, int size) {
        for (int i = 0; i < size / 2; i++) {
            arr[i] = arr[i] + arr[size - i - 1];
            arr[size - i - 1] = arr[i] - arr[size - i - 1];
            arr[i] = arr[i] - arr[size - i - 1];
        }
    }

    public static void reverseArray(int[] arr, int start, int end) {
        for (int i = start; i <= (end + start - 1) / 2; i++) {
            arr[i] = arr[i] + arr[end + start - i];
            arr[end + start - i] = arr[i] - arr[end + start - i];
            arr[i] = arr[i] - arr[end + start - i];
        }
    }

    public static void reverseArrayUsing3rdVariable(int[] arr, int size) {
        for (int i = 0; i < size / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[size - i - 1];
            arr[size - i - 1] = temp;
        }
    }

    public static void reverseArrayUsingXOR(int[] arr, int size) {
        for (int i = 0; i < size / 2; i++) {
            arr[i] = arr[i] ^ arr[size - i - 1];
            arr[size - i - 1] = arr[i] ^ arr[size - i - 1];
            arr[i] = arr[i] ^ arr[size - i - 1];
        }
    }

    public static void main(String[] args) {
        int[] ar = {10, 20, 30, 40, 50, 60, 70};
        reverseArray(ar, 3, 6);
        for (int a : ar)
            System.out.print(a + " ");
    }
}
