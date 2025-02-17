package src.search.workouts;

//https://leetcode.com/problems/search-a-2d-matrix
public class SearchA2DMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowSize = matrix.length, columnSize = matrix[0].length;
        // Processing like a 1D array
        int start = 0, end = rowSize * columnSize - 1, mid, rowIndex, columnIndex;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            rowIndex = mid / columnSize; // Conversion of 1D index to 2D row index
            columnIndex = mid % columnSize; // Conversion of 1D index to 2D column index
            if (matrix[rowIndex][columnIndex] == target)
                return true;
            else if (target > matrix[rowIndex][columnIndex])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }
}
