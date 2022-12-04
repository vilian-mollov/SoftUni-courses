package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    private static final int DEAD_HEALTH = 0;
    private static final int ALIVE_HEALTH = 10;
    private static final int EXPERIENCE = 30;

    private Dummy deadDummy;
    private Dummy aliveDummy;

    private static final int ATTACK_POINTS = 1;

    @Before
    public void setUp() {
        this.deadDummy = new Dummy(DEAD_HEALTH, EXPERIENCE);
        this.aliveDummy = new Dummy(ALIVE_HEALTH, EXPERIENCE);
    }


    @Test
    public void test_Dummy_LosesHealth_WhenAttacked() {
        aliveDummy.takeAttack(ATTACK_POINTS);

        assertEquals(ALIVE_HEALTH - ATTACK_POINTS, aliveDummy.getHealth());

    }


    @Test(expected = IllegalStateException.class)
    public void test_Dummy_ThrowsException_WhenAttacked_CannotBeAttacked() {
        deadDummy.takeAttack(ATTACK_POINTS);
    }


    @Test
    public void test_DeadDummy_GivesExperience() {
        int actual = deadDummy.giveExperience();
        assertEquals(EXPERIENCE, actual);
    }


    @Test(expected = IllegalStateException.class)
    public void test_AliveDummy_CantGive_Experience() {
        aliveDummy.giveExperience();
    }

    @Test
    public void test_AliveDummy_IsAlive() {
        assertFalse(aliveDummy.isDead());
    }

    @Test
    public void test_DeadDummy_IsDead() {
        assertTrue(deadDummy.isDead());
    }


}
