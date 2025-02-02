package src.arrays.workouts;

import java.util.Arrays;

// https://leetcode.com/problems/sort-colors
// Dutch National Flag Problem
public class SortColors_75 {
    public static void sortColors(int[] nums) {
        int red_0 = 0;
        int white_1 = 0;
        int blue_2 = 0;

        for (int n : nums) {
            if (n == 0)
                red_0++;
            else if (n == 1)
                white_1++;
            else
                blue_2++;
        }
        int i = 0;
        while (red_0 > 0) {
            nums[i++] = 0;
            red_0--;
        }
        while (white_1 > 0) {
            nums[i++] = 1;
            white_1--;
        }
        while (blue_2 > 0) {
            nums[i++] = 2;
            blue_2--;
        }
    }

    public static void sortColorsUsingFillMethod(int[] nums) {
        int red_0 = 0;
        int white_1 = 0;
        int blue_2 = 0;

        for (int n : nums) {
            if (n == 0)
                red_0++;
            else if (n == 1)
                white_1++;
            else
                blue_2++;
        }
        Arrays.fill(nums, 0, red_0, 0);
        Arrays.fill(nums, red_0, red_0 + white_1, 1);
        Arrays.fill(nums, red_0 + white_1, red_0 + white_1 + blue_2, 2);
    }

    public static void main(String[] args) {
        int[] ar = {0, 1, 0, 0, 0, 2, 2, 1};
//        sortColors(ar);
        for (int a : ar) {
            System.out.print(a + " ");
        }
    }
}
