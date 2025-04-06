package src.basicmaths.workouts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.geeksforgeeks.org/problems/product-of-primes5328/1
public class ProductOfPrimes {

    public static long primeProduct(long L, long R) {
        // code here
        boolean[] primeTable = segmentedSieve(L, R);
        long primeProductValue = 1;
        for (int i = 0; i < R - L + 1; i++) {
            if (primeTable[i]) {
                long value = Long.valueOf(i) + L;
                long modulo = (long) (Math.pow(10, 9) + 7);
                primeProductValue = (primeProductValue * value) % modulo;
            }
        }
        return primeProductValue;
    }

    // Using Segmented Sieve Algo to find prime between a range [L,R];
    public static boolean[] segmentedSieve(long L, long R) {
        List<Integer> basePrimes = sieve((int) Math.sqrt(R));
        boolean[] segmentedSieve = new boolean[(int) (R - L + 1)];
        Arrays.fill(segmentedSieve, true);
        if (L == 0) {
            segmentedSieve[0] = false;
            segmentedSieve[1] = false;
        }
        if (L == 1)
            segmentedSieve[0] = false;

        //Outer Loop
        for (int prime : basePrimes) {
            long firstMultiple = (L / prime) * prime;
            if (firstMultiple < L)
                firstMultiple += prime;

            //Inner Loop
            for (long j = Math.max(firstMultiple, prime * prime); j <= R; j = j + prime) {
                int index = (int) (j - L);
                segmentedSieve[index] = false;
            }
        }
        return segmentedSieve;
    }

    //Using Sieve of Eratosthenes algo for find the primes [0, n]
    public static List<Integer> sieve(int n) {
        boolean[] primeTable = new boolean[n + 1];
        Arrays.fill(primeTable, true); // marks all true assume all prime
        primeTable[0] = false;
        List<Integer> primeList = new ArrayList<>();
        if (n > 0) primeTable[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primeTable[i]) {
                primeList.add(i);
                for (int j = i * i; j <= n; j = j + i)
                    primeTable[j] = false;
            }
        }
        for (int i = (int) Math.sqrt(n) + 1; i <= n; i++)
            if (primeTable[i])
                primeList.add(i);
        return primeList;
    }

    public static void main(String[] args) {
        System.out.println(primeProduct(1, 20));
    }
}
