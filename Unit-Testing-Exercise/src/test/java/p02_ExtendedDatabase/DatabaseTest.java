package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private static Person[] people;
    private static Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        people = new Person[10];
        database = new Database(people);
    }

    @Test
    public void test_Database_Constructor_Creates_ValidDatabase() {
        assertArrayEquals(people, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Database_Constructor_ThrowsException_When_MoreThan16Elements_InParameter() throws OperationNotSupportedException {
        people = new Person[17];
        database = new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Database_Constructor_ThrowsException_When_LessThan_1_Element_InParameter() throws OperationNotSupportedException {
        people = new Person[0];
        database = new Database(people);
    }


}