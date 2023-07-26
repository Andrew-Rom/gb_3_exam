package Animals;

import java.util.ArrayList;
import java.util.Date;

public class Camel extends PackAnimals {
    public Camel(String GROUP, String NAME, Date BIRTHDAY, ArrayList<String> commands, int animalId) {
        super(GROUP, NAME, BIRTHDAY, commands, animalId);
    }

    public Camel(String NAME, Date BIRTHDAY, ArrayList<String> commands, int animalId) {
        this("Camels", NAME, BIRTHDAY, commands, animalId);
    }
}