package Animals;

import java.util.ArrayList;
import java.util.Date;

public abstract class PackAnimals extends Animal {

    public PackAnimals(String GROUP, String NAME, Date BIRTHDAY, ArrayList<String> commands, int animalId) {
        super("Pack animals", GROUP, NAME, BIRTHDAY, commands, animalId);
    }

}