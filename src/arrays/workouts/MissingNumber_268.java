package src.arrays.workouts;

//https://leetcode.com/problems/missing-number/
public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        int size = nums.length;
        int sumOfValues = 0;
        for (int num : nums)
            sumOfValues += num;
        int totalSumsOfN = (size * (size + 1)) / 2;
        return totalSumsOfN - sumOfValues;
    }
}
