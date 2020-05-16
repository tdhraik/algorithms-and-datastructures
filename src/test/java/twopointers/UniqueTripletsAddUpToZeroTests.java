package test.java.twopointers;

import main.java.twopointers.UniqueTripletsAddUpToZero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniqueTripletsAddUpToZeroTests {

    private final UniqueTripletsAddUpToZero uniqueTripletsAddUpToZero =
            new UniqueTripletsAddUpToZero();

    @Test
    public void shouldReturnTripletsAddingToZero() {
        int[] arr = {-3,0,1,2,-1,1,-2};
        int[] arr_1 = {-5,2,-1,-2,3};
        int[] arr_2 = {-6,-9,-2,7,2,0,2,4,1,2,-1};

        assertEquals(4, uniqueTripletsAddUpToZero.getUniqueTripletsAddingToZero(arr));
        assertEquals(2, uniqueTripletsAddUpToZero.getUniqueTripletsAddingToZero(arr_1));
        assertEquals(4, uniqueTripletsAddUpToZero.getUniqueTripletsAddingToZero(arr_2));
    }
}
