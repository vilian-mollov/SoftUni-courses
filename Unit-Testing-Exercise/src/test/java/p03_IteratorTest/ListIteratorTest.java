package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private static ListIterator listIterator;

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator("Java", "C#", "Python", "C++");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Constructor_Throws_Exception_When_Null_Passed_AsParameter() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }

    @Test
    public void test_MoveTheInternalIndexPosition_ToTheNextIndexPosition_ReturnsTrue_IfLastPosition_ReturnsFalse() {
        for (int i = 0; i < 3; i++) {
            assertTrue(listIterator.move());
        }
        assertFalse(listIterator.move());
    }

    @Test
    public void test_HasNext() {
        assertTrue(listIterator.hasNext()); // java
        listIterator.move();
        assertTrue(listIterator.hasNext()); // C#
        listIterator.move();
        assertTrue(listIterator.hasNext()); // Python
        listIterator.move();
        assertFalse(listIterator.hasNext()); // C++
    }

    @Test
    public void test_PrintElement_AtThe_InternalIndexPosition(){
        assertEquals("Java",listIterator.print()); // Java
        listIterator.move();
        assertEquals("C#",listIterator.print()); // C#
        listIterator.move();
        assertEquals("Python",listIterator.print()); // Python
    }
    @Test(expected = IllegalStateException.class)
    public void test_PrintElement_When_EmptyCollection_ShouldThrowException_IllegalStateException()throws OperationNotSupportedException{
        listIterator = new ListIterator();
        listIterator.print();
    }


}