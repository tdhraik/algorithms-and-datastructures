package main.java.slidingwindow;


/**
 * Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 * Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
 * Output: [2.2, 2.8, 2.4, 3.6, 2.8]
 */

public class SlidingWindowConcept {

    public float[] getContiguousSubArrayAverage( float[] arr, int size ) {
        if( arr.length < size ) {
            return null;
        }
        float[] averages = new float[arr.length + 1 - size];
        float subArraySum = 0;
        for (int i = 0; i < size; i++) {
            subArraySum += arr[i];
        }
        int index = 0;
        averages[index] = subArraySum/size;
        for (int i = size; i < arr.length; i++) {
            subArraySum = subArraySum + arr[i] - arr[i-size];
            averages[++index] = subArraySum/size;
        }
        for(float avg : averages) {
            System.out.println(avg);
        }
        return averages;
    }

}
