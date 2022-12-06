package p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    private static int[] arr = new int[]{5, 7, 4, 1, -9, 8, 2};

    @Test
    public void test_BubbleSort_Sorting_7_Elements() {
        Bubble.sort(arr);
        assertArrayEquals(new int[]{-9, 1, 2, 4, 5, 7, 8}, arr);
    }

    @Test
    public void test_BubbleSort_Sorting_2_Elements() {
        int[] actualArr = new int[]{5, 4};
        Bubble.sort(actualArr);
        assertArrayEquals(new int[]{4, 5}, actualArr);
    }

    @Test
    public void test_BubbleSort_Sorting_1_Elements() {
        int[] actualArr = new int[]{4};
        Bubble.sort(actualArr);
        assertArrayEquals(new int[]{4}, actualArr);
    }

    @Test
    public void test_BubbleSort_Sorting_0_Elements_Should_Do_Nothing() {
        int[] actualArr = new int[]{};
        Bubble.sort(actualArr);
        assertArrayEquals(new int[]{}, actualArr);
    }

}