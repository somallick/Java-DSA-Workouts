package src.basicmaths.workouts;

import java.math.BigInteger;

//https://leetcode.com/problems/super-pow
public class SuperPow_372 {
    public static int superPow(int a, int[] b) {
        StringBuilder bStr = new StringBuilder();
        for (int v : b)
            bStr = bStr.append(v);
        BigInteger bInt = new BigInteger(bStr.toString());
        BigInteger aInt = new BigInteger(String.valueOf(a));
        return aInt.modPow(bInt, new BigInteger("1337")).intValue();
    }

    public static void main(String[] args) {
        int a = 2;
        int[] b = {1, 0};
        System.out.println(superPow(a, b));
    }
}
