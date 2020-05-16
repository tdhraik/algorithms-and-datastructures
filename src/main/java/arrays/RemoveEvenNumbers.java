package main.java.arrays;

public class RemoveEvenNumbers {

    public int[] removeEvenNumbers(int[] arr) {
        int totalOddNumbers = 0;
        for (int anArr : arr) {
            if (anArr % 2 != 0) {
                totalOddNumbers++;
            }
        }
        int[] oddNumbersArr = new int[totalOddNumbers];
        int index = 0;
        for (int anArr : arr) {
            if (anArr % 2 != 0) {
                oddNumbersArr[index++] = anArr;
            }
        }
        return oddNumbersArr;
    }
}
