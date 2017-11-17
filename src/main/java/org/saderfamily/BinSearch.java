package org.saderfamily;

import java.util.Arrays;

public class BinSearch {
    private final static int[] empty = {};
    private final static int[] one_element = {1};
    private final static int[] three_elements = {1, 3, 5};
    private final static int[] four_elements = { 1, 3, 5, 7};

    public static void main(String[] args) {
        assert -1 == new BinSearch().chop(3, empty);
        assert -1 == new BinSearch().chop(3, one_element);
        assert 0 == new BinSearch().chop(1, one_element);

        assert 0 == new BinSearch().chop(1, three_elements);
        assert 1 == new BinSearch().chop(3, three_elements);
        assert 2 == new BinSearch().chop(5, three_elements);
        assert -1 == new BinSearch().chop(0, three_elements);
        assert -1 == new BinSearch().chop(2, three_elements);
        assert -1 == new BinSearch().chop(4, three_elements);
        assert -1 == new BinSearch().chop(6, three_elements);

        assert 0 == new BinSearch().chop(1, four_elements);
        assert 1 == new BinSearch().chop(3, four_elements);
        assert 2 == new BinSearch().chop(5, four_elements);
        assert 3 == new BinSearch().chop(7, four_elements);
        assert -1 == new BinSearch().chop(0, four_elements);
        assert -1 == new BinSearch().chop(2, four_elements);
        assert -1 == new BinSearch().chop(4, four_elements);
        assert -1 == new BinSearch().chop(6, four_elements);
        assert -1 == new BinSearch().chop(8, four_elements);

    }

    private int chop(int item, int[] array) {
        if(array.length == 0) {
            return -1;
        }

        int middle = array.length / 2;

        if(item == array[middle]) {
            return middle;
        }

        if(array.length == 1) {
            return item == array[0] ? 0 : -1;
        }

        if(item < array[middle]) {
            return chop(item, Arrays.copyOfRange(array, 0, middle));
        }
        return chop(item, Arrays.copyOfRange(array, middle, array.length)) > -1 ?
                chop(item, Arrays.copyOfRange(array, middle, array.length)) + middle : -1;
    }
}
