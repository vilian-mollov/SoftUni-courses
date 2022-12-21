package magicGame.models.region;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;

import java.util.ArrayList;
import java.util.Collection;

public class RegionImpl implements Region {

    private final Collection<BlackWidow> blackWidows;
    private final Collection<Wizard> wizards;

    public RegionImpl() {
        blackWidows = new ArrayList<>();
        wizards = new ArrayList<>();
    }

    @Override
    public String start(Collection<Magician> magicians) {

        for (Magician magician : magicians) {
            String name = magician.getClass().getSimpleName();
            if (name.equals("BlackWidow")) {
                blackWidows.add((BlackWidow) magician);
            } else if (name.equals("Wizard")) {
                wizards.add((Wizard) magician);
            }
        }


        while (true) {

            for (Wizard wizard : wizards) {
                if (wizard.getMagic().getBulletsCount() < 1)
                    continue;

                blackWidows.forEach(blackW -> blackW.takeDamage(wizard.getMagic().fire()));
            }

            int blackWidowHealthCount = blackWidows.stream().map(BlackWidow::getHealth).mapToInt(Integer::valueOf).sum();

            if (blackWidowHealthCount == 0)
                return "Wizards win!";

            for (BlackWidow blackWidow : blackWidows) {
                if (blackWidow.getMagic().getBulletsCount() < 10)
                    continue;

                wizards.forEach(wiz -> wiz.takeDamage(blackWidow.getMagic().fire()));
            }

            int wizardHealthCount = wizards.stream().map(Wizard::getHealth).mapToInt(Integer::valueOf).sum();

            if (wizardHealthCount == 0)
                return "Black widows win!";

        }
    }
}
