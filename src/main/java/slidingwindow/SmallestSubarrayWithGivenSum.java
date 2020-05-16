package main.java.slidingwindow;

/**
 * Given an array of positive numbers and a positive number ‘S’,
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
 * Return 0, if no such subarray exists.
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
 * Input: [3, 4, 1, 1, 6], S=8
 * Output: 3
 * Explanation: Smallest sub arrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
 *
 */
public class SmallestSubarrayWithGivenSum {

    public int smallestSubarrayWithGivenSum( int[] arr, int sum ) {

        int tempSum = 0, tempSize = 0, smallestSize = 0;
        while( tempSum >= sum ) {
            tempSum += arr[tempSize++];
        }
        smallestSize = tempSize;
        for (int i = tempSize; i < arr.length; i++) {
//            tempSum
        }
        return smallestSize;
    }
}
