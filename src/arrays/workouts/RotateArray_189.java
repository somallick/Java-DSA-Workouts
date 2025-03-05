package src.arrays.workouts;

import src.utility.PrintArray;

//https://leetcode.com/problems/rotate-array
public class RotateArray_189 {
    public static void rotate_sol1(int[] nums, int k) {
        // extra memory -> swap using temp array
        int n = nums.length;
        if (k % n == 0)
            return;
        k = k % n;
        int[] temp = new int[k];
        int index = 0;
        for (int i = n - k; i < n; i++)
            temp[index++] = nums[i];
        for (int i = n - 1; i >= k; i--)
            nums[i] = nums[i - k];
        for (int i = 0; i < temp.length; i++)
            nums[i] = temp[i];
    }

    public static void rotate_sol2(int[] nums, int k) {
        //Reverse array process
        int n = nums.length;
        k = k % n;
        if (k == 0)
            return;
        ArrayReverse.reverseArray(nums, 0, n - 1);
        ArrayReverse.reverseArray(nums, 0, k - 1);
        ArrayReverse.reverseArray(nums, k, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotate_sol2(arr, 3);
        PrintArray.printArray(arr);
    }
}
