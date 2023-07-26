package Animals;

import java.util.ArrayList;
import java.util.Date;

public class Cat extends Pets {

    public Cat(String GROUP, String NAME, Date BIRTHDAY, ArrayList<String> commands, int animalId) {
        super(GROUP, NAME, BIRTHDAY, commands, animalId);
    }

    public Cat(String NAME, Date BIRTHDAY, ArrayList<String> commands, int animalId) {
        this("Cats", NAME, BIRTHDAY, commands, animalId);
    }
}
