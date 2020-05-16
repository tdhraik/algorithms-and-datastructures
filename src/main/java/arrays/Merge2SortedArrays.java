package main.java.arrays;

public class Merge2SortedArrays {

    public int[] mergeAndSortArrays(int[] arr_1, int[] arr_2) {

        int index = 0;
        int[] mergedArr = new int[arr_1.length + arr_2.length];
        int index_2_Arr = 0;
        for (int i = 0; i < arr_1.length; i++) {
            if( arr_1[i] > arr_2[index_2_Arr] ) {
                mergedArr[index++] = arr_2[index_2_Arr++];
                i--;
            } else {
                mergedArr[index++] = arr_1[i];
            }
            if( i == (arr_1.length - 1) && index_2_Arr < (arr_2.length-1) ) {
                while(index_2_Arr < arr_2.length){
                    mergedArr[index++] = arr_2[index_2_Arr++];
                }
            }
        }
        while( index_2_Arr < arr_2.length) {
            mergedArr[index++] = arr_2[index_2_Arr++];
        }

        for(int m : mergedArr){
            System.out.println(m);
        }
        return mergedArr;
    }
}
