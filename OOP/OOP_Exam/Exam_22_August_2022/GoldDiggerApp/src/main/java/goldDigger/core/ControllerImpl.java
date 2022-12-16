package goldDigger.core;

import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private final DiscovererRepository discoverers;
    private final SpotRepository spots;
    private int spotsInspected;

    public ControllerImpl() {
        discoverers = new DiscovererRepository();
        spots = new SpotRepository();
        spotsInspected = 0;
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {

        Discoverer discoverer;
        if (kind.equals(Anthropologist.class.getSimpleName())) {
            discoverer = new Anthropologist(discovererName);
        } else if (kind.equals(Archaeologist.class.getSimpleName())) {
            discoverer = new Archaeologist(discovererName);
        } else if (kind.equals(Geologist.class.getSimpleName())) {
            discoverer = new Geologist(discovererName);
        } else {
            throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }

        discoverers.add(discoverer);
        return String.format(DISCOVERER_ADDED, kind, discovererName);

    }

    @Override
    public String addSpot(String spotName, String... exhibits) {

        Spot spot = new SpotImpl(spotName);

        for (String e : exhibits) {
            spot.getExhibits().add(e);
        }

        spots.add(spot);

        return String.format(SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {

        boolean isRemoved = discoverers.remove(discoverers.byName(discovererName));

        if (isRemoved) {
            return String.format(DISCOVERER_EXCLUDE, discovererName);
        } else {
            throw new IllegalArgumentException(String.format(DISCOVERER_DOES_NOT_EXIST, discovererName));
        }
    }

    @Override
    public String inspectSpot(String spotName) {

        ArrayList<Discoverer> units = (ArrayList<Discoverer>) discoverers.getCollection()
                .stream()
                .filter(d -> d.getEnergy() > 45)
                .collect(Collectors.toList());

        if (units.isEmpty()) {
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }

        Spot spot = spots.byName(spotName);
        Operation operation = new OperationImpl();
        operation.startOperation(spot, units);

        spotsInspected++;
        long excluded = units.stream().filter(d -> d.getEnergy() == 0).count();

        return String.format(INSPECT_SPOT, spotName, excluded);
    }

    @Override
    public String getStatistics() {

        StringBuilder out = new StringBuilder();
        out.append(String.format(FINAL_SPOT_INSPECT, this.spotsInspected));
        out.append(System.lineSeparator());
        out.append(FINAL_DISCOVERER_INFO);

        Collection<Discoverer> discoverers = this.discoverers.getCollection();
        for (Discoverer discoverer : discoverers) {
            out.append(System.lineSeparator());
            out.append(String.format(FINAL_DISCOVERER_NAME, discoverer.getName()));
            out.append(System.lineSeparator());
            out.append(String.format(FINAL_DISCOVERER_ENERGY, discoverer.getEnergy()));
            out.append(System.lineSeparator());
            if (discoverer.getMuseum().getExhibits().isEmpty()) {
                out.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, "None"));

            } else {
                out.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS,
                        String.join(FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER, discoverer.getMuseum().getExhibits())));
            }
        }
        return out.toString();
    }
}
