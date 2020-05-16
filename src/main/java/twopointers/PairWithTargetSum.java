package main.java.twopointers;


/**
 * the array should be sorted... for two pointers approach to work
 *
 */
public class PairWithTargetSum {

    public int[] getIndicesWithTargetSum(int[] arr, int targetSum) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end) {
            if( arr[start] + arr[end] == targetSum ) {
                return new int[]{start, end};
            }
            if( arr[start] + arr[end] > targetSum ) {
                end--;
            } else {
                start++;
            }
        }
        return new int[0];
    }
}
