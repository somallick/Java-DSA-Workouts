package src.recursion.workouts;

//https://www.geeksforgeeks.org/java-fibonacci-series
public class FibonacciSeriesRE {

    public static int getNthFibonacciNumber(int n) {
        if (n == 0 || n == 1)
            return n;
        int number = getNthFibonacciNumber(n - 1) + getNthFibonacciNumber(n - 2);
        return number;
    }

    //Fibonacci Series Using Recursive Approach
    public static int getNthFibonacciSeries(int n) {
        if (n == 0 || n == 1)
            return n;
        return getNthFibonacciSeries(n - 1) + getNthFibonacciSeries(n - 2);
    }

    //Fibonacci Series Using Memoization
    public static int getNthFibonacciSeries(int n, int[] memo) {
        if (memo[n] != 0)
            return memo[n];
        if (n == 1 || n == 2)
            return 1;
        else {
            memo[n] = getNthFibonacciSeries(n - 1, memo)
                    + getNthFibonacciSeries(n - 2, memo);
            return memo[n];
        }
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(n + "th fibonacci number is " + getNthFibonacciNumber(n));
        for (int i = 0; i <= n; i++)
            System.out.print(getNthFibonacciSeries(i) + " ");
        System.out.println();
        int[] memo = new int[n + 1];
        for (int i = 1; i <= n; i++)
            System.out.print(getNthFibonacciSeries(i, memo) + " ");
    }
}
