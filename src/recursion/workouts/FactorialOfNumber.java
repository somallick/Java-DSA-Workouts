package src.recursion.workouts;

public class FactorialOfNumber {
    public static int factorial(int n) {
        if (n == 0)
            return 1;
        int value = factorial(n - 1);
        int factorialValue = n * value;
        System.out.println(n + " * " + value + " = " + factorialValue);
        return factorialValue;
    }

    public static void main(String[] args) {
        int number = 5;
        factorial(5);
    }
}
