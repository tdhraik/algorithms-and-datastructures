package main.java.twopointers;

public class SquaringSortedArr {
    public int[] squareArr(int[] arr) {
        int[] result = new int[arr.length];
        int start = 0, end = arr.length-1, index = arr.length-1;
        while(start <= end) {
            if( (arr[start]*arr[start]) >= (arr[end]*arr[end]) ) {
                result[index--] = arr[start]*arr[start];
                start++;
            } else {
                result[index--] = arr[end]*arr[end];
                end--;
            }
        }
        return result;
    }
}
