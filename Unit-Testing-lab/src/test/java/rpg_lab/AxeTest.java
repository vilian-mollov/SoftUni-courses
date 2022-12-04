package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {
    private static final int ATTACK = 27;
    private static final int DURABILITY = 60;
    private static final int HEALTH = 30;
    private static final int EXPERIENCE = 1;
    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        //Arrange
        this.axe = new Axe(ATTACK, DURABILITY);
        this.dummy = new Dummy(HEALTH, EXPERIENCE);
    }

    @Test
    public void test_AxeCreation_WillReturn_SameValues_AsCreated() {
        assertEquals("Wrong initialization attack", ATTACK, axe.getAttackPoints());
        assertEquals("Wrong initialization durability", DURABILITY, axe.getDurabilityPoints());
    }

    @Test
    public void test_Axe_LoseDurability_AfterEach_Attack() {
        //Act
        axe.attack(dummy);
        //Assert
        assertEquals("Wrong Durability", DURABILITY - 1, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class) //Assert
    public void test_AxeAttack_WhenBroken_Fails() {
        //Arrange
        int axeDurability = 0;
        Axe axe = new Axe(ATTACK, axeDurability);

        //assert the axe is broken
        assertEquals("The test axe is not broken", 0, axeDurability);

        //Act
        axe.attack(dummy);


    }


}