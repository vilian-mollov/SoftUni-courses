package zoo.core;

import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static zoo.common.ConstantMessages.*;
import static zoo.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private final FoodRepository foodRepository;
    private final Map<String, Area> areas;

    public ControllerImpl() {
        foodRepository = new FoodRepositoryImpl();
        areas = new LinkedHashMap<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area;

        if (areaType.equals(LandArea.class.getSimpleName())) {
            area = new LandArea(areaName);
        } else if (areaType.equals(WaterArea.class.getSimpleName())) {
            area = new WaterArea(areaName);
        } else {
            throw new NullPointerException(INVALID_AREA_TYPE);
        }

        areas.put(areaName, area);

        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, area.getClass().getSimpleName());

    }

    @Override
    public String buyFood(String foodType) {
        Food food;

        if (Vegetable.class.getSimpleName().equals(foodType)) {
            food = new Vegetable();
        } else if (Meat.class.getSimpleName().equals(foodType)) {
            food = new Meat();
        } else {
            throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }

        foodRepository.add(food);

        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {

        Area area = areas.get(areaName);

        Food food = foodRepository.findByType(foodType);

        if (food == null) {
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        }

        assert area != null;
        area.addFood(food);


        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal;

        if (AquaticAnimal.class.getSimpleName().equals(animalType)) {
            animal = new AquaticAnimal(animalName, kind, price);
        } else if (TerrestrialAnimal.class.getSimpleName().equals(animalType)) {
            animal = new TerrestrialAnimal(animalName, kind, price);
        } else {
            throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }

        Area area = areas.get(areaName);

        assert area != null;
        String areaType = area.getClass().getSimpleName();

        boolean animalAmdAreaAreLandBased = areaType.equals("LandArea") && animal.getClass().getSimpleName().equals("TerrestrialAnimal");
        boolean animalAmdAreaAreWaterBased = areaType.equals("WaterArea") && animal.getClass().getSimpleName().equals("AquaticAnimal");

        if (animalAmdAreaAreLandBased || animalAmdAreaAreWaterBased) {
            area.addAnimal(animal);
        } else {
            return AREA_NOT_SUITABLE;
        }

        return String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, area.getName());

    }

    @Override
    public String feedAnimal(String areaName) {
        Area area = areas.get(areaName);
        assert area != null;
        area.feed();
        return String.format(ANIMALS_FED, area.getAnimals().size());
    }

    @Override
    public String calculateKg(String areaName) {
        Area area = areas.get(areaName);
        assert area != null;

        double kg = area.getAnimals().stream().mapToDouble(Animal::getKg).sum();
        return String.format(KILOGRAMS_AREA, area.getName(), kg);
    }

    @Override
    public String getStatistics() {
        return areas.values()
                .stream()
                .map(Area::getInfo)
                .collect(Collectors.joining(" "));
    }
}
