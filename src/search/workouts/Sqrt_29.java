package src.search.workouts;

import java.math.BigInteger;

//https://leetcode.com/problems/sqrtx
public class Sqrt_29 {
    public static int mySqrt_int(int x) {
        int start = 1, end = x;
        int mid, value = 0;

        while (start <= end) {
            mid = start + ((end - start) / 2);
            int product = mid * mid;
            if (product == x)
                return mid;
            else if (product < x) { // may be or may not be the answer hence store and compute
                value = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return value;
    }

    //Integer Size limit issue
    public static int mySqrt_bigInt(int x) {
        int start = 1, end = x;
        int mid, value = 0;

        while (start <= end) {
            mid = start + ((end - start) / 2);
            BigInteger product = BigInteger.valueOf(mid * mid);
            if (product.compareTo(BigInteger.valueOf(x)) == 0)
                return mid;
            else if (product.compareTo(BigInteger.valueOf(x)) < 0) {
                value = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return value;
    }

    // leetcode accepted solution
    // resolving the integer size limit issue by moving the variable between the two end equal or less than operator
    public static int mySqrt(int x) {
        int start = 1, end = x;
        int mid, value = 0;

        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (mid == x / mid)
                return mid;
            else if (mid < x / mid) {
                value = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return value;
    }

    // decimal precision scenario like sqrt(110) = 10.488
//    public static double mySqrtWithPrecision(int num, int precisionDigit) {
//        double step = 0.1;
//        int value = mySqrt(num);
//        while (precisionDigit<=0){
//            while( * )
//        }
//    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
