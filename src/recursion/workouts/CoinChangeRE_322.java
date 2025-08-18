package src.recursion.workouts;

//https://leetcode.com/problems/coin-change
public class CoinChangeRE_322 {
    //TLE will occur
    public static int coinsDenomination(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int minCoinsCount = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            // if coin value > amount value, no need to call recursive function
            // if coin value <= amount value, call recursive function
            if (coin <= amount) {
                int recursiveCount = coinsDenomination(coins, amount - coin);
                // invalid case -> recursion Answer -> Integer.MAX_VALUE;
                // valid case -> recursion Answer -> not equal to Integer.MAX_VALUE;
                if (recursiveCount != Integer.MAX_VALUE) {
                    int coinsUsed = 1 + recursiveCount;
                    minCoinsCount = Math.min(minCoinsCount, coinsUsed);
                }
            }
        }
        return minCoinsCount;
    }

    public static int coinChange(int[] coins, int amount) {
        int coinsUsed = coinsDenomination(coins, amount);
        if (coinsUsed == Integer.MAX_VALUE)
            return -1;
        return coinsUsed;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
}
