package src.arrays.workouts;

public class TransposeOfMatrix {
    public static void matrixTranspose(int[][] arr, int rowSize, int columnSize){
        for(int i =0; i<rowSize; i++) {
            for(int j=0; j<=i; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        PrintArray.printArray(arr);
        matrixTranspose(arr,3,3);
        PrintArray.printArray(arr);
    }
}
