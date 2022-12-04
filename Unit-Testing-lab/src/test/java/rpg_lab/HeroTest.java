package rpg_lab;

import org.junit.Test;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

import static org.junit.Assert.*;

public class HeroTest {

    //Example of stubbed implementation of Weapon just for tests

    private static class FakeWeapon implements Weapon{
        @Override
        public int getAttackPoints() {
            return 0;
        }

        @Override
        public int getDurabilityPoints() {
            return 0;
        }

        @Override
        public void attack(Target target) {

        }
    }

    private static final int XP = 200;

    @Test
    public void test_HeroGainXp_When_KillingTarget(){
        Hero hero = new Hero("Jakarto",new FakeWeapon());

        assertEquals(0,hero.getExperience());

        //Example of anonymous class instance of Target just to fake giveExperience() and isDead() methods
        Target fakeTarget = new Target() {
            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return XP;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };


        hero.attack(fakeTarget);

        assertEquals(XP,hero.getExperience());
    }



}