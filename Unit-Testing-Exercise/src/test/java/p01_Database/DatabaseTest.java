package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private static Database database;
    private static final Integer[] ELEMENTS = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(ELEMENTS);
    }

    @Test
    public void test_Database_Constructor_Initialize_Parameters_Right() {

        assertEquals(ELEMENTS.length, database.getElementsCount());

        for (int i = 0; i < ELEMENTS.length - 1; i++) {
            assertEquals(ELEMENTS[i], database.getElements()[i]);
        }

        assertEquals(ELEMENTS.length - 1, database.getIndex());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Database_Constructor_Initialize_Parameters_MoreThan16Elements_Throws_OperationNotSupportedException() throws OperationNotSupportedException {
        Database database = new Database(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Database_Constructor_Initialize_Parameters_LessThan1Elements_Throws_OperationNotSupportedException() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test
    public void test_Database_GetElementsMethod_ReturnElements() {
        Integer[] result = database.getElements();

        for (int i = 0; i < database.getElementsCount(); i++) {
            assertEquals(result[i], database.getElements()[i]);
        }
    }


    @Test
    public void test_Database_AddOperation_AddElement_At_The_Next_Free_Cell() throws OperationNotSupportedException {
        Integer number = 11;
        database.add(number);

        assertEquals(number, database.getElements()[10]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Database_AddOperation_Throws_OperationNotSupportedException_When_Added_Null_Element() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void test_Database_RemoveOperation_Should_RemoveElement_OnlyOnLast_Index_LikeStackDoes_LIFO() throws OperationNotSupportedException {
        int initialSize = database.getElements().length;
        database.remove();

        assertEquals(initialSize - 1, database.getElements().length);

        int lastIndex = database.getIndex();

        assertEquals(ELEMENTS[8], database.getElements()[lastIndex]);

        database.remove();
        lastIndex = database.getIndex();

        assertEquals(ELEMENTS[7], database.getElements()[lastIndex]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Database_RemoveOperation_WhenRemoveFrom_EmptyBase_ThrowsOperationNotSupportedException() throws OperationNotSupportedException {
        Integer[] numbers = {1};
        Database database = new Database(numbers);

        database.remove();
        database.remove();
    }

}