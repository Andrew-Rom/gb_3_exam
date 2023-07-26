package Animals;

import java.util.ArrayList;
import java.util.Date;

public abstract class Pets extends Animal {

    public Pets(String GROUP, String NAME, Date BIRTHDAY, ArrayList<String> commands, int animalId) {
        super("Pets", GROUP, NAME, BIRTHDAY, commands, animalId);
    }

}
