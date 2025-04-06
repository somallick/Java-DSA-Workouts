package src.arrays.workouts;

// https://leetcode.com/problems/single-number/
public class SingleNumber_136 {
    public static int singleNumber(int[] nums) {
        int xorValues = 0;
        for (int n : nums) {
            xorValues = xorValues ^ n;
        }
        return xorValues;
    }

    public static void main(String[] args) {
        int[] ar = {2, 2, 1};
        System.out.println(singleNumber(ar));
    }
}
