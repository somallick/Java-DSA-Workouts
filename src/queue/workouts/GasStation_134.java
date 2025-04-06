package src.queue.workouts;

//https://leetcode.com/problems/gas-station
public class GasStation_134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int deficientGas = 0;
        int balanceGas = 0;
        for (int i = 0; i < gas.length; i++) {
            if (balanceGas + gas[i] < cost[i]) {
                deficientGas += balanceGas + gas[i] - cost[i];
                start = i + 1;
                balanceGas = 0;
            } else {
                balanceGas = balanceGas + gas[i] - cost[i];
            }
        }
        if (balanceGas + deficientGas >= 0)
            return start;
        return -1;
    }
}
