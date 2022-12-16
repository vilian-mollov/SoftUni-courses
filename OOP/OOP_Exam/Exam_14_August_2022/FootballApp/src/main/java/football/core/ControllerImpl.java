package football.core;


import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepository supplement;
    private Map<String, Field> fields;
    // private List<Field> fields;


    public ControllerImpl() {
        supplement = new SupplementRepositoryImpl();
        fields = new LinkedHashMap<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {

        Field field;

        if (fieldType.equals(NaturalGrass.class.getSimpleName())) {
            field = new NaturalGrass(fieldName);
        } else if (fieldType.equals(ArtificialTurf.class.getSimpleName())) {
            field = new ArtificialTurf(fieldName);
        } else {
            throw new NullPointerException(INVALID_FIELD_TYPE);
        }

        fields.put(fieldName, field);
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {

        Supplement sup;
        if (type.equals(Liquid.class.getSimpleName())) {
            sup = new Liquid();
        } else if (type.equals(Powdered.class.getSimpleName())) {
            sup = new Powdered();
        } else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }

        supplement.add(sup);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {

        Supplement sup = supplement.findByType(supplementType);

        if (sup == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        fields.get(fieldName).addSupplement(sup);
        supplement.remove(sup);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {

        Player player;
        Field field = fields.get(fieldName);

        if (playerType.equals(Men.class.getSimpleName())) {
            player = new Men(playerName, nationality, strength);
            if (!field.getClass().getSimpleName().equals("NaturalGrass")) {
                return FIELD_NOT_SUITABLE;
            }
        } else if (playerType.equals(Women.class.getSimpleName())) {
            player = new Women(playerName, nationality, strength);
            if (!field.getClass().getSimpleName().equals("ArtificialTurf")) {
                return FIELD_NOT_SUITABLE;
            }
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        fields.get(fieldName).addPlayer(player);
        return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerName, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        fields.get(fieldName).drag();
        int numberOfPlayersDrag = fields.get(fieldName).getPlayers().size();
        return String.format(PLAYER_DRAG, numberOfPlayersDrag);
    }

    @Override
    public String calculateStrength(String fieldName) {
        int sum = 0;
        for (Player player : fields.get(fieldName).getPlayers()) {
            sum += player.getStrength();
        }
        return String.format(STRENGTH_FIELD, fieldName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Field> entry : fields.entrySet()) {
            sb.append(entry.getValue().getInfo());
        }
        return sb.toString();
    }
}
