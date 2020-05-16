package test.java.twopointers;

import main.java.twopointers.RemoveDuplicatesInSortedArr;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicateInSortedArrTests {

    private final RemoveDuplicatesInSortedArr removeDuplicatesInSortedArr =
            new RemoveDuplicatesInSortedArr();

    @Test
    void shouldReturnLenAfterRemovingDuplicatesFromArr() {
        int[] arr = {2,3,3,3,6,9,9};
        assertEquals(4, removeDuplicatesInSortedArr.removeDuplicates(arr));

        arr = new int[]{2,2,2,11};
        assertEquals(2, removeDuplicatesInSortedArr.removeDuplicates(arr));
    }
}
