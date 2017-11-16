package org.saderfamily;

import java.util.Arrays;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HeapSortTest {
    @Test
    public void testHeapsort() throws Exception {

        int[] numbers = {4, 10, 3, 5, 1};
        Arrays.sort(numbers);
        assertEquals(new HeapSort().heapsort(numbers), new int[]{1, 3, 4, 5, 10});
    }

}