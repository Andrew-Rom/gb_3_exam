package Animals;

import java.util.ArrayList;
import java.util.Date;

public class Dog extends Pets {

    public Dog(String GROUP, String NAME, Date BIRTHDAY, ArrayList<String> commands, int animalId) {
        super(GROUP, NAME, BIRTHDAY, commands, animalId);
    }

    public Dog(String NAME, Date BIRTHDAY, ArrayList<String> commands, int animalId) {
        this("Dogs", NAME, BIRTHDAY, commands, animalId);
    }

}
