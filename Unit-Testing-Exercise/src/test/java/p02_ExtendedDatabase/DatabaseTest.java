package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private static final Person person1 = new Person(14, "Toni");
    private static final Person person2 = new Person(15, "Jakarcho");
    private static final Person person3 = new Person(24, "Alukardcho");
    private static Person[] people;
    private static Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        people = new Person[3];
        people[0] = person1;
        people[1] = person2;
        people[2] = person3;
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

    @Test
    public void test_Add_ValidCase()throws OperationNotSupportedException{
        Person person = new Person(741,"Pesho");
        database.add(person);
        int lastPersonIndex = database.getElements().length-1;
        assertEquals(person,database.getElements()[lastPersonIndex]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Add_When_Null_Parameter_Is_Presented_Throws_O_N_S_Exception()throws OperationNotSupportedException{
        database.add(null);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void test_Add_When_ThereAre_MultipleUsers_With_TheSame_Id_Throws_O_N_S_Exception()throws OperationNotSupportedException{
        Person javcho = new Person(person1.getId(), "Javcho");
        database.add(javcho);
    }

    @Test
    public void test_Database_FindByUserName_ValidCase() throws OperationNotSupportedException {
        Person actualPerson = database.findByUsername(person2.getUsername());
        assertEquals(person2,actualPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Database_FindByUserName_When_NoUser_Is_Presented_ThrowsException_O_N_S_Exception()throws OperationNotSupportedException {
        Person actualPerson = database.findByUsername("Dany");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Database_FindByUserName_When_UsernameParameter_Is_Null_ThrowsException_O_N_S_Exception()throws OperationNotSupportedException {
        Person actualPerson = database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Database_FindByUserName_When_Arguments_AreAllCaseSensitive()throws OperationNotSupportedException {
        Person actualPerson = database.findByUsername("JaKaRcHo");
    }

    @Test
    public void test_Database_FindById_ValidCase() throws OperationNotSupportedException {
        Person actualPerson = database.findById(15);
        assertEquals(15, actualPerson.getId());
    }

    @Test
    public void test_Database_FindById_When_NoUser_IsPresented_ByThis_Id_Throws_Operation_N_S_Exception() {
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Database_FindById_When_MoreThanOne_User_Is_With_This_Id_Throws_O_N_S_Exception() throws OperationNotSupportedException {
        Person duplicate = new Person(15, "NotJakarcho");
        database.add(duplicate);

        database.findById(15);
    }


}