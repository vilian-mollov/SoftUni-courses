package cats;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseTests {
    House house;
    Cat cat;

    @Before
    public void setUp() {
        house = new House("Home", 3);
        cat = new Cat("Joshua");
    }


    @Test
    public void test_Constructor_ValidCase() {
        House house1 = new House("H1", 7);
        assertEquals(7, house1.getCapacity());
        assertEquals("H1",house1.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_ShouldThrowException_When_Capacity_NegativeNumber(){
        House house1 = new House("H1", -1);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrowException_When_Name_Is_Null(){
        House house1 = new House(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrowException_When_Name_Is_Whitespaces(){
        House house1 = new House("                    ", 1);
    }

    @Test
    public void test_AddCat_ValidCase(){
        assertEquals(0,house.getCount());
        house.addCat(cat);
        assertEquals(1,house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddCat_ShouldThrowException_When_NotEnough_Capacity(){
        house.addCat(cat);
        Cat cat1 = new Cat("1");
        Cat cat2 = new Cat("2");
        Cat cat3 = new Cat("3");
        house.addCat(cat1);
        house.addCat(cat2);
        house.addCat(cat3); // should throw exception
    }


    @Test
    public void test_removeCat_ValidCase(){
        assertEquals(0,house.getCount());
        house.addCat(cat);
        assertEquals(1,house.getCount());
        house.removeCat("Joshua");
        assertEquals(0,house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_removeCar_ThrowException_When_Null_AsArgument(){
        house.removeCat(null);
    }

    @Test
    public void test_CatForSale_ValidCase(){
        assertTrue(cat.isHungry());
        house.addCat(cat);
        house.catForSale("Joshua");
        assertFalse(cat.isHungry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CatForSale_ThrowsException_When_Null(){
        house.catForSale(null);
    }


    @Test
    public void test_Statistics_ValidCase(){
        house.addCat(cat);
        String actualTest = house.statistics();
        assertEquals("The cat Joshua is in the house Home!",actualTest);
    }
    @Test
    public void test_Statistics_ValidCase_With_MoreCats(){
        house.addCat(cat);
        Cat cat1 = new Cat("Jerry");
        Cat cat2 = new Cat("Terry");
        house.addCat(cat1);
        house.addCat(cat2);
        String actualTest = house.statistics();
        assertEquals("The cat Joshua, Jerry, Terry is in the house Home!",actualTest);
    }


}
