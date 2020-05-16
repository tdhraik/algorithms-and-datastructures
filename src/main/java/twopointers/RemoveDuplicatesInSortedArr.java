package main.java.twopointers;

public class RemoveDuplicatesInSortedArr {

    public int removeDuplicates(int[] arr) {
        int start = 0, end = 1, uniqueNumbers = 0;
        while(end <= arr.length-1) {
            if( arr[start++] != arr[end++]) {
                uniqueNumbers++;
            }
        }
        return uniqueNumbers+1;
    }
}
