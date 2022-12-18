package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT;
import static catHouse.common.ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseHouse implements House{

    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        toys = new ArrayList<>();
        cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        int sum = toys.stream().map(t-> t.getSoftness()).collect(Collectors.summingInt(Integer::intValue));
        return sum;
    }

    @Override
    public void addCat(Cat cat) {
            if(cats.size() >= capacity){
                throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CAT);
            }
        cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public void feeding() {
        cats.stream().forEach(c -> c.eating());
    }

    @Override
    public String getStatistics() {

        String catsOutput = cats.isEmpty() ? "none" : cats.stream().map(Cat::getName).collect(Collectors.joining(" "));

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s:",name,this.getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Cats: %s",catsOutput));
        sb.append(System.lineSeparator());
        sb.append(String.format("Toys: %d Softness: %d",toys.size(),this.sumSoftness()));

        return sb.toString();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return toys;
    }
}
