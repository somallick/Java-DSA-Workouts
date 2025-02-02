package src.arrays.workouts;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/spiral-matrix
public class SpiralMatrix_54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<>();
        int topIndex = 0;
        int bottomIndex = matrix.length-1;
        int leftIndex = 0;
        int rightIndex = matrix[0].length-1;

        while(topIndex<=bottomIndex && leftIndex<=rightIndex) {

            for (int i = leftIndex; i<=rightIndex; i++)
                spiralList.add(matrix[topIndex][i]);
            topIndex++;

            for (int i = topIndex; i<=bottomIndex; i++)
                spiralList.add(matrix[i][rightIndex]);
            rightIndex--;

            if(topIndex<=bottomIndex){
                for (int i = rightIndex; i>=leftIndex; i--)
                    spiralList.add(matrix[bottomIndex][i]);
                bottomIndex--;
            }

            if(leftIndex<=rightIndex) {
                for (int i= bottomIndex; i>=topIndex; i--)
                    spiralList.add(matrix[i][leftIndex]);
                leftIndex++;
            }
        }
        return spiralList;
    }

    public static void main (String[] args)
    {
        int[][] arr = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 },
                { 17, 18, 19, 20 } };

        List<Integer> spiralList = spiralOrder(arr);

    }
}
