package Animals;

import java.util.ArrayList;
import java.util.Date;

public class Horse extends PackAnimals {

    public Horse(String GROUP, String NAME, Date BIRTHDAY, ArrayList<String> commands, int animalId) {
        super(GROUP, NAME, BIRTHDAY, commands, animalId);
    }

    public Horse(String NAME, Date BIRTHDAY, ArrayList<String> commands, int animalId) {
        this("Horses", NAME, BIRTHDAY, commands, animalId);
    }
}
