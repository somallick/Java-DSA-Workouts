package src.utility;

public class PrintArray {
    public static void printArray(int[] arr) {
        for (int a : arr)
            System.out.print(a + " ");
        System.out.println();
    }

    public static void printArray(int[] arr, int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void printArray(int[][] arr) {
        for (int rowCell[] : arr) {
            for (int cellValue : rowCell) {
                System.out.print(cellValue + " ");
            }
            System.out.println();
        }
    }
    public static <T> void printArray(T[] arr) {
        for (T a : arr)
            System.out.print(a + " ");
        System.out.println();
    }
    public static <T> void printArray(T[] arr, int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static <T> void printArray(T[][] arr) {
        for (T rowCell[] : arr) {
            for (T cellValue : rowCell) {
                System.out.print(cellValue + " ");
            }
            System.out.println();
        }
    }
}
