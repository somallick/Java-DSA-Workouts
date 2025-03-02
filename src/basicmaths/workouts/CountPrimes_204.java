package src.basicmaths.workouts;

import java.util.Arrays;

//https://leetcode.com/problems/count-primes
public class CountPrimes_204 {

    //SQRT Approach
    public int countPrimes_sol1(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    public boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Sieve of Eratosthenes Approach
    public int countPrimes_sol2(int n) {
        boolean[] primeTable = new boolean[n + 1]; // 0->n
        Arrays.fill(primeTable, true); // marks all true assume all prime
        primeTable[0] = false;
        if (n > 0) primeTable[1] = false;
        int primeCount = 0;
        for (int i = 2; i < n; i++) {
            if (primeTable[i]) {
                primeCount++;
                for (int j = i * 2; j <= n; j = j + i) // multiple of i
                    primeTable[j] = false; // multiple of i are not prime
            }
        }
        return primeCount;
    }

    // Sieve of Eratosthenes Optimised Approach -> O(N∗Log(Log(N)))
    public int countPrimes_sol3(int n) {
        boolean[] primeTable = new boolean[n + 1]; // 0->n
        Arrays.fill(primeTable, true); // marks all true assume all prime
        primeTable[0] = false;
        if (n > 0) primeTable[1] = false;
        int primeCount = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primeTable[i]) {
                primeCount++;
                for (int j = i * i; j <= n; j = j + i) // multiple of i
                    primeTable[j] = false; // multiple of i are not prime
            }
        }
        for (int i = (int) Math.sqrt(n) + 1; i <= n; i++) // iterating on the index which are greater than sqrt(n) to count those primes
            if (primeTable[i]) primeCount++;
        return primeCount;
    }
}
