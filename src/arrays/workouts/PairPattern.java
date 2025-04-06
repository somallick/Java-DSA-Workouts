package src.arrays.workouts;

public class PairPattern {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
            }
            System.out.println();
        }
        System.out.println("---------------1------------------");
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
            }
            System.out.println("");
        }
        System.out.println("----------------2-----------------");
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
            }
            System.out.println("");
        }
        System.out.println("----------------3-----------------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
            }
            System.out.println("");
        }
        System.out.println("----------------4-----------------");
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
            }
            System.out.println("");
        }
        System.out.println("----------------5-----------------");
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
            }
            System.out.println("");
        }
    }
}
