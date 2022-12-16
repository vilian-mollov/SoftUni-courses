package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;

public class OperationImpl implements Operation {

    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {

        ArrayList<String> exhibits = (ArrayList<String>) spot.getExhibits();

        for (Discoverer discoverer : discoverers) {
            boolean canDig = discoverer.canDig();

            while (canDig) {
                if (exhibits.isEmpty()) {
                    break;
                }
                discoverer.getMuseum().getExhibits().add(exhibits.get(0));
                exhibits.remove(0);
                discoverer.dig();
                canDig = discoverer.canDig();
            }
        }

    }
}
