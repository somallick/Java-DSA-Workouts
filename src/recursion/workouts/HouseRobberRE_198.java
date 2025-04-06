package src.recursion.workouts;

//https://leetcode.com/problems/house-robber
public class HouseRobberRE_198 {

    public static int robMoney(int[] nums, int index) {
        if (index >= nums.length)
            return 0;

        // include
        int includeMoney = nums[index] + robMoney(nums, index + 2);
        // exclude
        int excludeMoney = 0 + robMoney(nums, index + 1);

        return Math.max(includeMoney, excludeMoney);
    }

    public static int rob(int[] nums) {
        return robMoney(nums, 0);
    }

    public static void main(String[] args) {
        int[] houseMoney = {2, 7, 9, 3, 1};
        System.out.println(rob(houseMoney));
    }
}
