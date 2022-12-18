package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private ToyRepository toys;
    private Map<String, House> houses;

    public ControllerImpl() {
        toys = new ToyRepository();
        houses = new LinkedHashMap<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        if (type.equals("ShortHouse")) {
            house = new ShortHouse(name);
        } else if (type.equals("LongHouse")) {
            house = new LongHouse(name);
        } else {
            throw new NullPointerException(INVALID_HOUSE_TYPE);
        }

        houses.put(name, house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        if (type.equals("Ball")) {
            toy = new Ball();
        } else if (type.equals("Mouse")) {
            toy = new Mouse();
        } else {
            throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }

        toys.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = toys.findFirst(toyType);

        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }

        House house = houses.get(houseName);
        house.buyToy(toy);

        toys.removeToy(toy);

        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        if (catType.equals("ShorthairCat")) {
            cat = new ShorthairCat(catName, catBreed, price);
        } else if (catType.equals("LonghairCat")) {
            cat = new LonghairCat(catName, catBreed, price);
        } else {
            throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }

        House house = houses.get(houseName);

        boolean longCatAndHouse = cat.getClass().getSimpleName().equals("LonghairCat")
                && house.getClass().getSimpleName().equals("LongHouse");
        boolean shortCatAndHouse = cat.getClass().getSimpleName().equals("ShorthairCat")
                && house.getClass().getSimpleName().equals("ShortHouse");

        if(longCatAndHouse || shortCatAndHouse){
            house.addCat(cat);
        }else{
            return UNSUITABLE_HOUSE;
        }

        return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        House house = houses.get(houseName);

        house.feeding();

        return String.format(FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = houses.get(houseName);
        BigDecimal catsValue = new BigDecimal(0);
        for (Cat cat : house.getCats()) {
            catsValue = catsValue.add(BigDecimal.valueOf(cat.getPrice()));
        }
        BigDecimal toysValue = new BigDecimal(0);
        for (Toy toy : house.getToys()) {
            toysValue = toysValue.add(BigDecimal.valueOf(toy.getPrice()));
        }
        BigDecimal sum = new BigDecimal(0);
        sum = catsValue.add(toysValue);
        return String.format(VALUE_HOUSE, houseName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, House> entry : houses.entrySet()) {
            sb.append(entry.getValue().getStatistics());
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
