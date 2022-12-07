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
    public void setUp() {
        customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(num0);
        customLinkedList.add(num1);
        customLinkedList.add(num2);
        customLinkedList.add(num3);
    }


    @Test
    public void test_GetElement_At_SpecificIndex() {
        int actualNum = customLinkedList.get(1);
        assertEquals(num1, actualNum);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetElement_At_InvalidIndex_LessThan_0_ThrowsException() {
        customLinkedList.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetElement_At_InvalidIndex_MoreThan_Length_MinusOne_ThrowsException() {
        customLinkedList.get(4);
    }

    @Test
    public void test_SetElement_At_SpecificIndex() {
        customLinkedList.set(0, 23);
        assertEquals(23, (int) customLinkedList.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_SetElement_At_InvalidIndex_LessThan_0_ThrowsException() {
        customLinkedList.set(-1, 23);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_SetElement_At_InvalidIndex_MoreThan_Length_MinusOne_ThrowsException() {
        customLinkedList.set(50, 23);
    }

    @Test
    public void test_RemoveAt_Index_Return_Value_When_Removed() {
        int actualValue = customLinkedList.removeAt(2);
        assertEquals(num2, actualValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveAt_Index_ThrowsException_When_Parameter_LessThan_0_applied() {
        customLinkedList.removeAt(-1);
    }


    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveAt_Index_ThrowsException_When_Parameter_MoreThan_Length_MinusOne_Applied() {
        customLinkedList.removeAt(600);
    }

    @Test
    public void test_Remove_ValidCase_WhenRemoved_ReturnCurrentIndex(){
       int actualIndex= customLinkedList.remove(num1);
        assertEquals(1,actualIndex);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Remove_When_OneElement_LeftWith_EmptyList() {
        CustomLinkedList<Integer> oneElementList = new CustomLinkedList<>();
        oneElementList.add(1);
        Integer n = 1;
        oneElementList.remove(n);

        oneElementList.get(0); /** throws exception if list is empty **/
    }

    @Test
    public void test_Remove_Null_Element_IfNotFound_Return_MinusOne(){
       int actualNumber = customLinkedList.remove(null);
        assertEquals(-1,actualNumber);
    }

    @Test
    public void test_Remove_NotExisting_Element_IfNotFound_Return_MinusOne(){
        int actualNumber = customLinkedList.remove(724);
        assertEquals(-1,actualNumber);
    }

    @Test
    public void test_IndexOf_ValidCase_Return_FirstTime_EncounterOf_The_SearchedElement_In_The_List(){
        customLinkedList.add(7);  /** Integer 7 at index 4 **/
        int actualIndex = customLinkedList.indexOf(num2); /** this is Integer 7 at index 2 **/
        assertEquals(2,actualIndex); /** should return first encountered Integer value of 7 **/
    }

    @Test
    public void test_IndexOf_Where_NoSuchElementExists_In_The_List_ShouldReturn_MinusOne(){
       int actualIndex = customLinkedList.indexOf(7589);
       assertEquals(-1,actualIndex);
    }

    @Test
    public void test_IndexOf_Where_NullElement_AsArgument_ShouldReturn_MinusOne(){
        int actualIndex = customLinkedList.indexOf(null);
        assertEquals(-1,actualIndex);
    }

    @Test
    public void test_Contains_ValidCase_ShouldReturn_True_Where_Found(){
        boolean found = customLinkedList.contains(7);
        assertTrue(found);
    }

    @Test
    public void test_Contains_Null_ShouldReturn_False_Where_NotFound(){
        boolean found = customLinkedList.contains(null);
        assertFalse(found);
    }

    @Test
    public void test_Contains_Where_NoSuchElementExists_In_The_List_ShouldReturn_False(){
        boolean found = customLinkedList.contains(0);
        assertFalse(found);
    }

}