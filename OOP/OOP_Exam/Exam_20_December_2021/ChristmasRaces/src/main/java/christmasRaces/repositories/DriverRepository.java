package christmasRaces.repositories;

import christmasRaces.entities.drivers.Driver;
import christmasRaces.repositories.interfaces.Repository;

import java.util.*;

public class DriverRepository implements Repository<Driver> {

    private Map<String,Driver> drivers;

    public DriverRepository() {
        drivers = new LinkedHashMap<>();
    }

    @Override
    public Driver getByName(String name) {
        return drivers.get(name);
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(drivers.values());
    }

    @Override
    public void add(Driver model) {
        drivers.putIfAbsent(model.getName(),model);
    }

    @Override
    public boolean remove(Driver model) {
        return drivers.remove(model.getName()) != null;
    }
}
