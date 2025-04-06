package src.arrays.workouts;

//https://www.geeksforgeeks.org/add-two-numbers-represented-by-two-arrays/
public class AddTwoNumbersRepresentedByTwoArrays {
    public static int calSumUtil(int a[], int b[], int m, int n) {
        int aI = m - 1, bI = n - 1, i = 0;
        int sum = 0, rem = 0, carry = 0;
        int finalValue = 0;
        while (aI >= 0 && bI >= 0) {
            sum = a[aI] + b[bI] + carry;
            rem = sum % 10;
            carry = sum / 10;
            finalValue = (int) (rem * Math.pow(10, i++)) + finalValue;
            aI--;
            bI--;
        }
        while (aI >= 0) {
            sum = a[aI] + carry;
            rem = sum % 10;
            carry = sum / 10;
            finalValue = (int) (rem * Math.pow(10, i++)) + finalValue;
            aI--;
        }
        while (bI >= 0) {
            sum = b[bI] + carry;
            rem = sum % 10;
            carry = sum / 10;
            finalValue = (int) (rem * Math.pow(10, i++)) + finalValue;
            bI--;
        }
        if (carry != 0)
            finalValue = (int) (carry * Math.pow(10, i)) + finalValue;
        return finalValue;
    }

    public static void main(String[] args) {
        int a[] = {9, 5, 4, 9};
        int b[] = {2, 1, 4};

        int n = a.length;
        int m = b.length;
        System.out.println(calSumUtil(a, b, n, m));
    }

    public String calSumUtil(int arr1[], int arr2[]) {
        int aI = arr1.length - 1, bI = arr2.length - 1;
        int sum, rem, carry = 0;
        String finalValue = "";
        while (aI >= 0 && bI >= 0) {
            sum = arr1[aI] + arr2[bI] + carry;
            rem = sum % 10;
            carry = sum / 10;
            finalValue = rem + finalValue;
            aI--;
            bI--;
        }
        while (aI >= 0) {
            sum = arr1[aI] + carry;
            rem = sum % 10;
            carry = sum / 10;
            finalValue = rem + finalValue;
            aI--;
        }
        while (bI >= 0) {
            sum = arr2[bI] + carry;
            rem = sum % 10;
            carry = sum / 10;
            finalValue = rem + finalValue;
            bI--;
        }
        if (carry != 0)
            finalValue = carry + finalValue;
        return finalValue;
    }
}
