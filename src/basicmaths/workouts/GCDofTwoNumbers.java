package src.basicmaths.workouts;

import java.math.BigInteger;

// https://www.geeksforgeeks.org/problems/gcd-of-two-numbers3459/1
public class GCDofTwoNumbers {
    public static int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        while (a > 0 && b > 0) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return (a == 0) ? b : a;
    }

    public static int gcd_sol2(int a, int b) {
        // code here
        if (a == 0) // (a==b)
            return b;
        else if (a > b)
            return gcd_sol2(a - b, b);
        else
            return gcd_sol2(b - a, a);
    }

    public static BigInteger gcd_sol3(String a, String b) {
        // code here
        BigInteger num1 = new BigInteger(a);
        BigInteger num2 = new BigInteger(b);
        return num1.gcd(num2);

    }

    public static void main(String[] args) {
        int num1 = 500;
        int num2 = 350;
        System.out.println(gcd_sol3(String.valueOf(num1), String.valueOf(num2)));
        System.out.println(gcd_sol2(num1, num2));
    }
}
