package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GarageTests {

    private Car car;
    private Garage garage;

    @Before
    public void setUp() {
        garage = new Garage();
        car = new Car("Porsche", 124, 10000);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_GetCars_ShouldReturnUnmodifiable_Collection_ThrowException_WhenTryToRemove_Element() {
        garage.addCar(car);
        garage.getCars().remove(0);
    }

    @Test
    public void test_GetCount_ValidCase() {
        garage.addCar(car);
        int actualCount = garage.getCount();
        assertEquals(1, actualCount);
    }

    @Test
    public void test_Constructor_ValidCase() {
        Garage garage1 = new Garage();
        List<Car> actualList = garage1.getCars();
        List<Car> expectedList = new ArrayList<>();
        assertEquals(expectedList, actualList);
    }

    @Test
    public void test_FindAllCarsWithMaxSpeedAbove() {
        Car car1 = new Car("BMW", 50, 50.20);
        garage.addCar(car1);
        garage.addCar(car);
        Car car2 = new Car("Audi", 20, 50.20);
        garage.addCar(car2);

        List<Car> expectedCars = new ArrayList<>();
        expectedCars.add(car1);
        expectedCars.add(car);

        assertEquals(expectedCars, garage.findAllCarsWithMaxSpeedAbove(40));

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddCar_ShouldThrow_Exception_WhenCarIsNull() {
        garage.addCar(null);
    }

    @Test
    public void test_AddCar_validCase() {
        garage.addCar(car);
        assertEquals(car,garage.getCars().get(0));
    }

    @Test
    public void test_GetTheMostExpensiveCar_Return_Null_If_EmptyList(){
        Car car1 = garage.getTheMostExpensiveCar();
        assertNull(car1);
    }

    @Test
    public void test_GetTheMostExpensiveCar_ValidCase_(){
        garage.addCar(car);
        garage.addCar(new Car("BMW", 50, 50.20));
        garage.addCar(new Car("Honda", 50, 70.20));
        Car car1 = garage.getTheMostExpensiveCar();
        assertEquals(car,car1);
    }

    @Test
    public void test_FindAllCarsByBrand_ReturnEmptyList_IfNoSuchBrand(){
        garage.addCar(car);
        garage.addCar(new Car("BMW", 50, 50.20));
        garage.addCar(new Car("Honda", 50, 70.20));

        List<Car> expectedList = new ArrayList<>();
        assertEquals(expectedList,garage.findAllCarsByBrand("Jajabajajbaja"));
    }

    @Test
    public void test_FindAllCarsByBrand_CorrectList_WhenHasABrand(){
        garage.addCar(car);
        garage.addCar(new Car("BMW", 50, 50.20));
        garage.addCar(new Car("Honda", 50, 70.20));

        List<Car> expectedList = new ArrayList<>();
        expectedList.add(car);
        assertEquals(expectedList,garage.findAllCarsByBrand("Porsche"));
    }



}