package goldDigger.models.discoverer;

import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

import static goldDigger.common.ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO;
import static goldDigger.common.ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY;

public abstract class BaseDiscoverer implements Discoverer {

    private String name;
    private double energy;
    private Museum museum;
    private static final int DEFAULT_ENERGY_INSPECT = 15;

    public BaseDiscoverer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        this.museum = new BaseMuseum();
    }

    private void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(DISCOVERER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    private void setEnergy(double energy) {

        if (energy < 0) {
            throw new IllegalArgumentException(DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }

        this.energy = energy;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public void dig() {
        this.energy = Math.max(0, this.energy - DEFAULT_ENERGY_INSPECT);
    }

    @Override
    public boolean canDig() {
        return energy > 0;
    }

    @Override
    public Museum getMuseum() {
        return museum;
    }
}
