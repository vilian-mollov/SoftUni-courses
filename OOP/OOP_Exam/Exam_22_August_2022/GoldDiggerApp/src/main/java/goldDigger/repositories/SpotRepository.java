package goldDigger.repositories;

import goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SpotRepository implements Repository<Spot>{

    private final Collection<Spot> spots;

    public SpotRepository() {
        spots = new ArrayList<>();
    }

    @Override
    public Collection<Spot> getCollection() {
        return Collections.unmodifiableCollection(spots);
    }

    @Override
    public void add(Spot spot) {
        spots.add(spot);
    }

    @Override
    public boolean remove(Spot spot) {
        return spots.remove(spot);
    }

    @Override
    public Spot byName(String name) {
        return spots.stream()
                .filter(s -> s.getName().equals(name))
                .findAny()
                .orElse(null);
    }
}
