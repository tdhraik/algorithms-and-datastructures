package main.java.twopointers;

/**
 * Given an array containing 0s, 1s and 2s, sort the array in-place.
 * You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
 * https://en.wikipedia.org/wiki/Dutch_national_flag_problem
 *
 * Input: [1, 0, 2, 1, 0]
 * Output: [0 0 1 1 2]
 *
 */
public class DutchNationalFlagProblem {
    public int[] sortArr(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        for (int i = 0; i <= end; i++) {
            if( arr[i] == 0 ) {
                swap(arr, i, start);
                start++;
            } else if ( arr[i] == 2 ) {
                swap(arr, i, end);
                end--;
                i--;
            }
        }
        return arr;
    }

    private void swap(int[] arr, int from, int to) {
        int temp = arr[to];
        arr[to] = arr[from];
        arr[from] = temp;
    }
}
