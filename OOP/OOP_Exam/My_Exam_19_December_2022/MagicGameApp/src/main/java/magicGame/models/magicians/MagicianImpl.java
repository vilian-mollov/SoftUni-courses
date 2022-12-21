package magicGame.models.magicians;

import magicGame.models.magics.Magic;

import static magicGame.common.ExceptionMessages.*;

public abstract class MagicianImpl implements Magician {

    private String name;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    public MagicianImpl(String name, int health, int protection, Magic magic) {
        setName(name);
        setHealth(health);
        setProtection(protection);
        setMagic(magic);
        setAlive();
    }

    private void setAlive() {
        if (health > 0) {
            isAlive = true;
            return;
        }
        isAlive = false;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(INVALID_MAGICIAN_NAME);
        }
        this.name = name;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    private void setProtection(int protection) {
        if (protection < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    private void setMagic(Magic magic) {
        if (magic == null) {
            throw new NullPointerException(INVALID_MAGIC);
        }
        this.magic = magic;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getProtection() {
        return protection;
    }

    @Override
    public Magic getMagic() {
        return magic;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void takeDamage(int points) {
        if (protection >= points) {
            protection -= points;
        } else {
            int exceed = points - protection;
            protection = 0;
            if (health > exceed) {
                health -= exceed;
            } else {
                health = 0;
                isAlive = false;
            }
        }
    }

    @Override
    public String toString() {
        String text = String.format("%s: %s", this.getClass().getSimpleName(), name) +
                System.lineSeparator() +
                String.format("Health: %d", health) +
                System.lineSeparator() +
                String.format("Protection: %d", protection) +
                System.lineSeparator() +
                String.format("Magic: %s", magic.getName());

        return text.trim();
    }
}
