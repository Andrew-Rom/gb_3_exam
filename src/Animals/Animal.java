package Animals;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public abstract class Animal {
    protected final String TYPE;
    protected final String GROUP;

    protected final String NAME;

    protected final Date BIRTHDAY;

    protected ArrayList<String> commands;
    protected int animalId;

    public Animal(String TYPE, String GROUP, String NAME, Date BIRTHDAY, ArrayList<String> commands, int animalId) {
        this.TYPE = TYPE;
        this.GROUP = GROUP;
        this.NAME = NAME;
        this.BIRTHDAY = BIRTHDAY;
        this.commands = commands;
        this.animalId = animalId;
    }

    public String getGROUP() {
        return GROUP;
    }

    public String getNAME() {
        return NAME;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void addCommands(String command) {
        commands.add(command);
    }

    public int getAnimalId() {
        return animalId;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "TYPE='" + TYPE + '\'' +
                ", GROUP='" + GROUP + '\'' +
                ", NAME='" + NAME + '\'' +
                ", BIRTHDAY=" + BIRTHDAY +
                ", animalId=" + animalId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return getAnimalId() == animal.getAnimalId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnimalId());
    }
}
