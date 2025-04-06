package src.basicmaths.workouts;

//https://www.geeksforgeeks.org/problems/modular-exponentiation-for-large-numbers5537/1
public class ModularExponentiationForLargeNumbers {
    public long PowMod(long x, long n, long m) {
        // Code here
        long ans = 1;
        while (n > 0) {
            if (n % 2 != 0) {
                ans = (ans * x) % m; // modulus to handle the large value
            }
            x = (x * x) % m; // modulus to handle the large value
            n = n / 2;
        }
        return ans;
    }
}
