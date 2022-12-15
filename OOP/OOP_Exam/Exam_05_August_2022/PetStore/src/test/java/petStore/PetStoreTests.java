package petStore;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PetStoreTests {

    private PetStore petStore;
    private Animal animal;

    @Before
    public void setUp() {
        petStore = new PetStore();
        animal = new Animal("Dog", 7, 72.42);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_GetAnimals_ShouldReturn_UnmodifiableList() {
        List<Animal> list = petStore.getAnimals();
        list.remove(0);
    }

    @Test
    public void test_GetCount_ShouldReturn_ListSize(){
        petStore.addAnimal(animal);
        int actualCount = petStore.getCount();
        assertEquals(1,actualCount);
    }

    @Test
    public void test_FindAllAnimalsWithMaxKilograms_Should_ReturnList_Of_AnimalsWithGreaterThan_5_MaxKilograms(){
        petStore.addAnimal(animal);
        petStore.addAnimal(new Animal("Cat", 4,12.32));
        petStore.addAnimal(new Animal("Rabbit", 5,27.22));

       List<Animal> actualList = petStore.findAllAnimalsWithMaxKilograms(5);
       List<Animal> expectedList = new ArrayList<>();
       expectedList.add(animal);

       assertEquals(expectedList,actualList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddAnimal_Should_Return_IllegalArgumentException_WhenNullAs_Argument(){
        petStore.addAnimal(null);
    }
    @Test
    public void test_AddAnimal_ValidCase(){
        petStore.addAnimal(animal);
        Animal actualAnimal = petStore.getAnimals().get(0);

        assertEquals(animal,actualAnimal);
    }

    @Test
    public void test_GetTheMostExpensiveAnimal_Return_Null_WhenEmptyList(){
        Animal actualAnimal = petStore.getTheMostExpensiveAnimal();
        assertNull(actualAnimal);
    }

    @Test
    public void test_GetTheMostExpensiveAnimal_ValidCase(){
        petStore.addAnimal(animal);
        petStore.addAnimal(new Animal("Cat", 4,12.32));
        petStore.addAnimal(new Animal("Rabbit", 5,27.22));
        Animal actualAnimal = petStore.getTheMostExpensiveAnimal();

        assertEquals(animal,actualAnimal);
    }

    @Test
    public void test_FindAllAnimalBySpecie_Return_EmptyList(){
        List<Animal> actualList = petStore.findAllAnimalBySpecie("Dog");
        List<Animal> expectedList = new ArrayList<>();
        assertEquals(expectedList,actualList);
    }

    @Test
    public void test_FindAllAnimalBySpecie_ValidCase(){
        petStore.addAnimal(animal);
        Animal dog = new Animal("Dog", 4,12.32);
        petStore.addAnimal(dog);
        petStore.addAnimal(new Animal("Cat", 5,27.22));
        List<Animal> actualList = petStore.findAllAnimalBySpecie("Dog");

        List<Animal> expectedList = new ArrayList<>();
        expectedList.add(animal);
        expectedList.add(dog);

        assertEquals(expectedList,actualList);
    }

}

