package football.entities.player;

public class Women extends BasePlayer{

    private final static double INITIAL_KILOGRAMS = 60.00;
    private final static int INCREASE_STRENGTH = 115;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, INITIAL_KILOGRAMS, strength);
    }

    @Override
    public void stimulation() {
        this.strength += INCREASE_STRENGTH;
    }
}
