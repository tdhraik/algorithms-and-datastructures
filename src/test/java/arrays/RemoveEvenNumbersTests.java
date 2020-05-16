package test.java.arrays;

import main.java.arrays.RemoveEvenNumbers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RemoveEvenNumbersTests {

    private final RemoveEvenNumbers removeEvenNumbers
            = new RemoveEvenNumbers();

    @Test
    void shouldRemoveEvenNumbers() {
        int[] arr = {1,2,4,5,6,8,10};

        assertArrayEquals(new int[]{1,5}, removeEvenNumbers.removeEvenNumbers(arr));
    }
}
