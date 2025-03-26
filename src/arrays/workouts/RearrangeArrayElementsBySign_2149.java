package src.arrays.workouts;

//https://leetcode.com/problems/rearrange-array-elements-by-sign
public class RearrangeArrayElementsBySign_2149 {
    public int[] rearrangeArray(int[] nums) {
        int p = 0, n = 1;
        int[] arr = new int[nums.length];
        for (int num : nums) {
            if (num > 0) {
                arr[p] = num;
                p += 2;
            } else {
                arr[n] = num;
                n += 2;
            }
        }
        return arr;
    }
}
