package main.java.twopointers;

/**
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 *
 */
public class UniqueTripletsAddUpToZero {

    public int getUniqueTripletsAddingToZero(int[] arr) {
        quickSortRecursive(arr);
        int totalPairs = 0;
        for (int i = 0; i < arr.length; i++) {
            totalPairs += getNumberOfPairsAddingToGivenSum(arr, i+1, -arr[i]);
        }
        return totalPairs;
    }

    private int getNumberOfPairsAddingToGivenSum( int[] arr, int start, int sum ) {
        int end = arr.length-1, totalPairs = 0;
        while(start<=end){
            if( (arr[start] + arr[end]) == sum) {
                totalPairs++;
                start++;
                end--; // so that same pair is not considered again
            } else if( (arr[start] + arr[end]) < sum) {
                start++;
            } else {
                end--;
            }
        }
        return totalPairs;
    }

    private void quickSortRecursive(int[] arr) {
        quickSortRecursive(arr, 0, arr.length-1);
    }

    private void quickSortRecursive(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSortRecursive(arr, begin, partitionIndex-1);
            quickSortRecursive(arr, partitionIndex+1, end);
        }
    }

    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

}
