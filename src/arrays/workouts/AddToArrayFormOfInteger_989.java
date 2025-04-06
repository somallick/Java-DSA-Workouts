package src.arrays.workouts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/add-to-array-form-of-integer
public class AddToArrayFormOfInteger_989 {
    public static List<Integer> addToArrayForm(int[] num, int k) {

        int val = k, n = num.length, i = n - 1, rem = 0, carry = 0, sum = 0;
        List<Integer> list = new ArrayList<>();

        while (val > 0 && i >= 0) {
            rem = val % 10;
            sum = (rem + num[i] + carry) % 10;
            carry = (rem + num[i] + carry) / 10;
            i--;
            val = val / 10;
            list.add(sum);
        }
        while (i >= 0) {
            sum = (num[i] + carry) % 10;
            carry = (num[i] + carry) / 10;
            i--;
            list.add(sum);
        }
        while (val > 0) {
            rem = val % 10;
            sum = (rem + carry) % 10;
            carry = (rem + carry) / 10;
            val = val / 10;
            list.add(sum);
        }
        if (carry > 0)
            list.add(carry);
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {9, 9, 9, 9};
        int k = 999999;
        addToArrayForm(arr, k).stream().forEach(i -> System.out.print(i + " "));

    }
}
