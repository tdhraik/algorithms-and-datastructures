package main.java.slidingwindow;

/**
 * Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 *
 * Input: [2, 3, 4, 1, 5], k=2
 * Output: 7
 */
public class MaxSumSubarraySizeK {

    public int maxSubArraySumSizeK( int[] arr, int size ) {
        if( arr.length < size ) {
            throw new IllegalStateException();
        }
        int tempSum = 0;
        for (int i = 0; i < size; i++) {
            tempSum += arr[i];
        }
        int maxSum = tempSum;
        for (int i = size; i < arr.length; i++) {
            tempSum += + arr[i] - arr[i-size];
            if( tempSum > maxSum ) {
                maxSum = tempSum;
            }
        }
        return maxSum;
    }
}
