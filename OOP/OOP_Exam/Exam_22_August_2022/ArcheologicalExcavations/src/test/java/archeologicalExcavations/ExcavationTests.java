package archeologicalExcavations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExcavationTests {

    private Archaeologist archaeologist;
    private Excavation excavation;

    @Before
    public void setUp() {
        archaeologist = new Archaeologist("Indiana Jones", 42);
        excavation = new Excavation("Pyramids", 3);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_Should_Throw_NullPointerException_WhenNameIs_Null() {
        Excavation test = new Excavation(null, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_Should_Throw_IllegalArgumentException_WhenCapacityIs_LessThanZero() {
        Excavation test = new Excavation("Pyramids", -1);
    }

    @Test
    public void test_Constructor_ValidCase() {
        Excavation test = new Excavation("Pyramids", 4);
        assertEquals("Pyramids", test.getName());
        assertEquals(4, test.getCapacity());
        assertEquals(0, test.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddArchaeologist_ShouldThrow_IllegalArgumentException_WhenCapacityIsFull() {
        excavation.addArchaeologist(archaeologist); //capacity is 3
        excavation.addArchaeologist(new Archaeologist("Andrew", 17));
        excavation.addArchaeologist(new Archaeologist("Jack", 32));
        excavation.addArchaeologist(new Archaeologist("Steven", 21));//should throw exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddArchaeologist_ShouldThrow_IllegalArgumentException_When_AlreadyExist_In_The_Collection() {
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist);
    }

    @Test
    public void test_AddArchaeologist_ValidCase() {
        excavation.addArchaeologist(archaeologist);
        int actualCount = excavation.getCount();
        assertEquals(1, actualCount);
    }

    @Test
    public void test_RemoveArchaeologist_Return_False_When_Null_As_Argument() {
        excavation.addArchaeologist(archaeologist);
        boolean isRemoved = excavation.removeArchaeologist(null);
        assertFalse(isRemoved);
    }

    @Test
    public void test_RemoveArchaeologist_Should_Return_False_When_No_SuchArchaeologist_InTheCollectionToRemove_As_Argument() {
        excavation.addArchaeologist(archaeologist);
        Archaeologist archaeologistToRemove = new Archaeologist("Removos", 42);
        boolean isRemoved = excavation.removeArchaeologist(archaeologistToRemove.getName());
        assertFalse(isRemoved);
    }

    @Test
    public void test_RemoveArchaeologist_ValidCase_ShouldReturnTrue_WhenArchaeologist_Removed_Successfully() {
        excavation.addArchaeologist(archaeologist);
        boolean isRemoved = excavation.removeArchaeologist(archaeologist.getName());
        assertTrue(isRemoved);
    }


}
