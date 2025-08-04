package src.recursion.workouts;

import java.util.Arrays;

//https://www.geeksforgeeks.org/java-fibonacci-series
public class FibonacciSeriesRE {

    //Fibonacci Series Using Recursive Approach
    public static int getNthFibonacciNumber(int n) {
        if (n == 0 || n == 1) return n;
        return getNthFibonacciNumber(n - 1) + getNthFibonacciNumber(n - 2);
    }

    // Here a = 0, b = 1 => this is the assumed constants
    public static void printFibonacciTillN(int a, int b, int n) {
        if (n > 0) {
            System.out.print(a + " ");
            printFibonacciTillN(b, a + b, n - 1);
        }
    }

    /*
     * Fibonacci Series Using Memoization - Applicable for Large n -> TC O(n) & SC O(n)
     * The memo array stores computed Fibonacci numbers to avoid redundant calculations.
     * Each value is initialized to -1 to indicate it hasn’t been computed yet.
     * The recursive function checks the array before computing a new value.
     */
    public static int getNthFibonacciSeries(int n, int[] memo) {
        if (n <= 1)
            return n;
        if (memo[n] != -1)
            return memo[n];
        memo[n] = getNthFibonacciSeries(n - 1, memo) + getNthFibonacciSeries(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(n + "th fibonacci number is " + getNthFibonacciNumber(n));

        for (int i = 0; i < n; i++)
            System.out.print(getNthFibonacciNumber(i) + " ");
        System.out.println();

        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        for (int i = 0; i < n; i++)
            System.out.print(getNthFibonacciSeries(i, memo) + " ");
        System.out.println();

        printFibonacciTillN(0, 1, n);
    }
}
