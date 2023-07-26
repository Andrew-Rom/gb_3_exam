package Animals;

import java.util.ArrayList;
import java.util.Date;

public class Donkey extends PackAnimals {
    public Donkey(String GROUP, String NAME, Date BIRTHDAY, ArrayList<String> commands, int animalId) {
        super(GROUP, NAME, BIRTHDAY, commands, animalId);
    }

    public Donkey(String NAME, Date BIRTHDAY, ArrayList<String> commands, int animalId) {
        this("Donkeys", NAME, BIRTHDAY, commands, animalId);
    }
}
