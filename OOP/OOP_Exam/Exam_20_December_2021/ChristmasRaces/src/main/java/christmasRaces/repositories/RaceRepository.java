package christmasRaces.repositories;

import christmasRaces.entities.races.Race;
import christmasRaces.repositories.interfaces.Repository;

import java.util.*;

public class RaceRepository implements Repository<Race> {

    private Map<String,Race> races;

    public RaceRepository() {
        races = new LinkedHashMap<>();
    }

    @Override
    public Race getByName(String name) {
        return races.get(name);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(races.values());
    }

    @Override
    public void add(Race model) {
        races.putIfAbsent(model.getName(),model);
    }

    @Override
    public boolean remove(Race model) {
        return races.remove(model.getName()) != null;
    }
}
