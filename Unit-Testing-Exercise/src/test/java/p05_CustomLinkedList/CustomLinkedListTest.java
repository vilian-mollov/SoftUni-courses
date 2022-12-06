package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {
        private static CustomLinkedList<Integer> customLinkedList;

        private static final int num0 = 14;
        private static final int num1 = 3;
        private static final int num2 = 7;
        private static final int num3 = 5;

        @Before
        public void setUp(){
            customLinkedList = new CustomLinkedList<>();
            customLinkedList.add(num0);
            customLinkedList.add(num1);
            customLinkedList.add(num2);
            customLinkedList.add(num3);
        }


    @Test
    public void test_GetElement_At_SpecificIndex(){
        int actualNum = customLinkedList.get(1);
        assertEquals(num1,actualNum);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetElement_At_InvalidIndex_LessThan_0_ThrowsException(){
        customLinkedList.get(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_GetElement_At_InvalidIndex_MoreThan_Length_MinusOne_ThrowsException(){
        customLinkedList.get(4);
    }

    @Test
    public void test_SetElement_At_SpecificIndex(){
            customLinkedList.set(0,23);
            assertEquals(23,(int)customLinkedList.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_SetElement_At_InvalidIndex_LessThan_0_ThrowsException(){
        customLinkedList.set(-1,23);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_SetElement_At_InvalidIndex_MoreThan_Length_MinusOne_ThrowsException(){
        customLinkedList.set(50,23);
    }

}