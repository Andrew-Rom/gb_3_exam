import Animals.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Controller {

    public static ArrayList<Animal> zoo = new ArrayList<>();

    /**
     * Method for initializing work with animal collection.
     * Show main menu.
     */
    public static void init() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    Main menu:
                    1 - Add a new animal
                    2 - Show what animal can do
                    3 - Add new command for animal
                    4 - Show info about an animal
                    0 - EXIT
                    >\s""");
            var selection = sc.next();
            switch (selection) {
                case "1" -> addAnimal();
                case "2" -> showAnimalCommands();
                case "3" -> addNewCommand();
                case "4" -> showAnimalInfo();
                case "0" -> {
                    System.out.println("Bye");
                    System.exit(0);
                }
                default -> System.out.println("Incorrect selection. Try again.");
            }
        }
    }

    /**
     * Method for collecting information about some new animal and add it into collection.
     * After that printing out note about added animal.
     */
    public static void addAnimal() {
        String typeNewAnimal = askType();
        int groupNewAnimal = 0;
        switch (typeNewAnimal) {
            case "Pets" -> groupNewAnimal = askPetGroup();
            case "Pack animals" -> groupNewAnimal = askPackAnimalGroup();
        }
        String nameNewAnimal = askAnimalName();
        Date birthdayNewAnimal = askBirthday();
        ArrayList<String> commandsNewAnimal = askAnimalCommands();
        int idNewAnimal = Counter.add();
        switch (groupNewAnimal) {
            case 11 -> {
                Animal newAnimal = new Dog(nameNewAnimal, birthdayNewAnimal, commandsNewAnimal, idNewAnimal);
                zoo.add(newAnimal);
                System.out.println(newAnimal + " was added.");
            }
            case 12 -> {
                Animal newAnimal = new Cat(nameNewAnimal, birthdayNewAnimal, commandsNewAnimal, idNewAnimal);
                zoo.add(newAnimal);
                System.out.println(newAnimal + " was added.");
            }
            case 13 -> {
                Animal newAnimal = new Hamster(nameNewAnimal, birthdayNewAnimal, commandsNewAnimal, idNewAnimal);
                zoo.add(newAnimal);
                System.out.println(newAnimal + " was added.");
            }
            case 21 -> {
                Animal newAnimal = new Horse(nameNewAnimal, birthdayNewAnimal, commandsNewAnimal, idNewAnimal);
                zoo.add(newAnimal);
                System.out.println(newAnimal + " was added.");
            }
            case 22 -> {
                Animal newAnimal = new Camel(nameNewAnimal, birthdayNewAnimal, commandsNewAnimal, idNewAnimal);
                zoo.add(newAnimal);
                System.out.println(newAnimal + " was added.");
            }
            case 23 -> {
                Animal newAnimal = new Donkey(nameNewAnimal, birthdayNewAnimal, commandsNewAnimal, idNewAnimal);
                zoo.add(newAnimal);

                System.out.println(newAnimal + " was added.");
            }
        }
    }

    /**
     * Method for input list of animal's commands.
     *
     * @return ArrayList with commands.
     */
    private static ArrayList<String> askAnimalCommands() {
        ArrayList<String> getCommands = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter animal's command: ");
        getCommands.add(scanner.next());
        return getCommands;
    }

    /**
     * Method for selection animal's type.
     *
     * @return String with type name.
     */
    private static String askType() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    Select animal type:
                    1 - Pets
                    2 - Pack animals
                    >\s""");
            var selection = scanner.next();
            switch (selection) {
                case "1" -> {
                    return "Pets";
                }
                case "2" -> {
                    return "Pack animals";
                }
                default -> System.out.println("Incorrect selection. Try again.");
            }
        }
    }

    /**
     * Method for selection group of pets.
     *
     * @return Code (int) with group.
     */
    private static int askPetGroup() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    Select pet's group:
                    1 - Dogs
                    2 - Cats
                    3 - Hamsters
                    >\s""");
            var selection = scanner.next();
            switch (selection) {
                case "1" -> {
                    return 11;
                }
                case "2" -> {
                    return 12;
                }
                case "3" -> {
                    return 13;
                }
                default -> System.out.println("Incorrect selection. Try again.");
            }
        }
    }

    /**
     * Method for selection group of pack animals.
     *
     * @return Code (int) with group.
     */
    private static int askPackAnimalGroup() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    Select pack animal's group:
                    1 - Horses
                    2 - Camels
                    3 - Donkeys
                    >\s""");
            var selection = scanner.next();
            switch (selection) {
                case "1" -> {
                    return 21;
                }
                case "2" -> {
                    return 22;
                }
                case "3" -> {
                    return 23;
                }
                default -> System.out.println("Incorrect selection. Try again.");
            }
        }
    }

    /**
     * Method for entering a new animal's name.
     *
     * @return String with name.
     */
    private static String askAnimalName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter animal's name: ");
        return scanner.next();
    }

    /**
     * Method for entering a new animal's birthday.
     *
     * @return Birthday in Date format.
     * @throws ParseException if entered string can not be parsed.
     * @throws Exception      in case getting unexpected error.
     */
    private static Date askBirthday() {
        boolean askUser = true;
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date getBirthday = null;
        Scanner scanner = new Scanner(System.in);
        while (askUser) {
            System.out.print("Enter the birthday " +
                    "(in format YYYY-MM-DD, where YYYY - year, MM - month, DD - day, e.g. 2020-12-31) > ");
            String getFromUser = scanner.nextLine();

            try {
                getBirthday = ft.parse(getFromUser);
                askUser = false;
            } catch (ParseException e) {
                System.out.println("Incorrect input");
            } catch (Exception e) {
                System.out.println("Unknown error");
            }
        }
        return getBirthday;
    }

    /**
     * Method for searching list of animal's commands by animal ID.
     * Print out list of animal's commands if ID is find.
     * Print out message if ID is not find.
     *
     * @throws Exception in case incorrect input.
     */
    public static void showAnimalCommands() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The collection contains information about next animals:");
        for (Animal animal : zoo) {
            System.out.println("ID " + animal.getAnimalId() + " > " + animal.getGROUP() + " - " + animal.getNAME());
        }
        System.out.print("Enter animal's ID for getting list of its commands > ");
        try {
            int selection = scanner.nextInt();
            for (Animal animal : zoo) {
                if (selection == animal.getAnimalId()) {
                    System.out.println(animal.getCommands());
                    break;
                } else {
                    System.out.println("Sorry, entered ID was not find it collection.");
                }
            }
        } catch (Exception e) {
            System.out.println("Incorrect input");
        }
    }

    /**
     * Method for adding a new command into list of animal's commands.
     * Add a new command into list of animal's commands if ID is find.
     * Print out message if ID is not find.
     *
     * @throws Exception in case incorrect input.
     */
    public static void addNewCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The collection contains information about next animals:");
        for (Animal animal : zoo) {
            System.out.println("ID " + animal.getAnimalId() + " > " + animal.getGROUP() + " - " + animal.getNAME());
        }
        System.out.print("Enter animal's ID which was trained a new command  > ");
        try {
            int selection = scanner.nextInt();
            for (Animal animal : zoo) {
                if (selection == animal.getAnimalId()) {
                    System.out.print("Enter a new command: ");
                    animal.addCommands(scanner.next());
                    break;
                } else {
                    System.out.println("Sorry, entered ID was not find it collection.");
                }
            }
        } catch (Exception e) {
            System.out.println("Incorrect input");
        }
    }

    /**
     * Method for searching animal by ID.
     * Print out info of animal if ID is find.
     * Print out message if ID is not find.
     *
     * @throws Exception in case incorrect input.
     */
    public static void showAnimalInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The collection contains information about next animals:");
        for (Animal animal : zoo) {
            System.out.println("ID " + animal.getAnimalId() + " > " + animal.getGROUP() + " - " + animal.getNAME());
        }
        System.out.print("Enter animal's ID for getting information about it > ");
        try {
            int selection = scanner.nextInt();
            for (Animal animal : zoo) {
                if (selection == animal.getAnimalId()) {
                    System.out.println(animal);
                    break;
                } else {
                    System.out.println("Sorry, entered ID was not find it collection.");
                }
            }
        } catch (Exception e) {
            System.out.println("Incorrect input");
        }
    }

}
