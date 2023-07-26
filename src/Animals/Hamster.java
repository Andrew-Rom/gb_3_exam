package Animals;

import java.util.ArrayList;
import java.util.Date;

public class Hamster extends Pets {

    public Hamster(String GROUP, String NAME, Date BIRTHDAY, ArrayList<String> commands, int animalId) {
        super(GROUP, NAME, BIRTHDAY, commands, animalId);
    }

    public Hamster(String NAME, Date BIRTHDAY, ArrayList<String> commands, int animalId) {
        this("Hamsters", NAME, BIRTHDAY, commands, animalId);
    }
}
