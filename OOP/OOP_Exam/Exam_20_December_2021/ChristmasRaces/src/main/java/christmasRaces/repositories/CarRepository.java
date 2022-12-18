package christmasRaces.repositories;

import christmasRaces.entities.cars.Car;
import christmasRaces.repositories.interfaces.Repository;

import java.util.*;

public class CarRepository implements Repository<Car> {

    private Map<String,Car> models;

    public CarRepository() {
        models = new LinkedHashMap<>();
    }

    @Override
    public Car getByName(String name) {
        return models.get(name);
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Car model) {
        models.putIfAbsent(model.getModel(),model);
    }

    @Override
    public boolean remove(Car model) {
        return models.remove(model.getModel()) != null;
    }
}
