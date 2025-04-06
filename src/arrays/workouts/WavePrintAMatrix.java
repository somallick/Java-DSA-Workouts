package src.arrays.workouts;

//https://www.geeksforgeeks.org/print-matrix-in-wave-form/
public class WavePrintAMatrix {
    public static void WavePrint(int rowSize, int colSize, int[][] arr) {
        for (int i = 0; i < colSize; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < rowSize; j++)
                    System.out.print(arr[j][i] + " ");
            } else {
                for (int k = rowSize - 1; k >= 0; k--)
                    System.out.print(arr[k][i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}};
        int R = 5, C = 4;
        WavePrint(R, C, arr);
    }
}
