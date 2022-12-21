package magicGame;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MagicianTests {

    private Magician magician;
    private Magic magic;

    @Before
    public void setUp() {
        magician = new Magician("Harry", 5);
        magic = new Magic("Aloha", 3);
    }

    @Test
    public void test_Constructor_ValidCase() {
        Magician mag = new Magician("Ron", 14);
        assertEquals("Ron", mag.getUsername());
        assertEquals(14, mag.getHealth());
        ArrayList<Magic> expectedMagic = new ArrayList<>();
        assertEquals(expectedMagic, mag.getMagics());

    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_Should_Throw_Exception_When_Name_ArgumentIs_Null() {
        Magician mag = new Magician(null, 14);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_Should_Throw_Exception_When_Name_ArgumentIs_WhiteSpaces() {
        Magician mag = new Magician("      ", 14);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_Should_Throw_Exception_When_Health_Argument_LessThanZero() {
        Magician mag = new Magician("Ron", -1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_GetMagics_ReturnUnmodifiable_Collection_ValidCase() {
        magician.addMagic(magic);
        magician.getMagics().remove(0);
    }

    @Test
    public void test_TakeDamage_ValidCase() {
        Magician mag = new Magician("Ron", 4);
        mag.takeDamage(1);
        assertEquals(3, mag.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void test_TakeDamage_Magician_IsDead() {
        Magician mag = new Magician("Ron", 0);
        mag.takeDamage(1);
    }

    @Test
    public void test_AddMagic_ValidCase() {
        magician.addMagic(magic);
    }

    @Test(expected = NullPointerException.class)
    public void test_AddMagic_Null() {
        magician.addMagic(null);
    }

    @Test
    public void test_RemoveMagic_Valid() {
        magician.addMagic(magic);
        boolean actualIsRemoved = magician.removeMagic(magic);
        assertTrue(actualIsRemoved);
    }

    @Test
    public void test_RemoveMagic_Valid_NoSuchMagic() {
        magician.addMagic(magic);
        Magic magic1 = new Magic("asd", 2);
        boolean actualIsRemoved = magician.removeMagic(magic1);
        assertFalse(actualIsRemoved);
    }

    @Test
    public void test_GetMagic_ValidCase() {
        magician.addMagic(magic);
        Magic m = magician.getMagic("Aloha");
        assertEquals(magic, m);
    }

    @Test
    public void test_GetMagic_NoSuchMagic() {
        magician.addMagic(magic);
        Magic m = magician.getMagic("Hi");
        assertNull(m);
    }


}
