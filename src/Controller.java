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
    private static void addAnimal() {
        String typeNewAnimal = getAnimalType();
        int groupNewAnimal = 0;
        switch (typeNewAnimal) {
            case "Pets" -> groupNewAnimal = getPetGroup();
            case "Pack animals" -> groupNewAnimal = getPackAnimalGroup();
        }
        String nameNewAnimal = getAnimalName();
        Date birthdayNewAnimal = getAnimalBirthday();
        ArrayList<String> commandsNewAnimal = getAnimalCommand();
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
    private static ArrayList<String> getAnimalCommand() {
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
    private static String getAnimalType() {
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
    private static int getPetGroup() {
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
    private static int getPackAnimalGroup() {
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
    private static String getAnimalName() {
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
    private static Date getAnimalBirthday() {
        boolean askUser = true;
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date animalBirthday = null;
        Scanner scanner = new Scanner(System.in);
        while (askUser) {
            System.out.print("Enter the birthday " +
                    "(in format YYYY-MM-DD, where YYYY - year, MM - month, DD - day, e.g. 2020-12-31) > ");
            String getFromUser = scanner.nextLine();

            try {
                animalBirthday = ft.parse(getFromUser);
                askUser = false;
            } catch (ParseException e) {
                System.out.println("Incorrect input");
            } catch (Exception e) {
                System.out.println("Unknown error");
            }
        }
        return animalBirthday;
    }

    /**
     * Method for printing out list of animal's commands.
     */
    private static void showAnimalCommands() {
        System.out.println(findAnimal().getCommands());
    }

    /**
     * Method for adding a new command into list of animal's commands.
     */
    private static void addNewCommand() {
        Animal trainedAnimal = findAnimal();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a new command: ");
        trainedAnimal.addCommands(scanner.next());
        System.out.println("New command was added successfully");
    }

    /**
     * Method for printing out info of animal if ID is find.
     */
    private static void showAnimalInfo() {
        System.out.println(findAnimal());
    }

    /**
     * Method for printing out data about all animals from collection.
     */
    private static void showAllAnimals() {
        System.out.println("The collection contains information about next animals:");
        for (Animal animal : zoo) {
            System.out.println("ID " + animal.getAnimalId() + " > " + animal.getGROUP() + " - " + animal.getNAME());
        }
    }

    /**
     * Method for searching animal by ID.
     * Print out message if ID is not find.
     *
     * @return object type Animal
     * @throws Exception in case incorrect input.
     */
    private static Animal findAnimal() {
        Animal selectedAnimal = null;
        boolean ask = true;
        Scanner scanner = new Scanner(System.in);
        showAllAnimals();
        try {
            while (ask) {
                System.out.print("Enter selected animal's ID > ");
                int selection = scanner.nextInt();
                for (Animal animal : zoo) {
                    if (selection == animal.getAnimalId()) {
                        selectedAnimal = animal;
                        ask = false;
                    }
                }
                if (ask) System.out.println("Sorry, entered ID was not find it collection. Try again \n");
            }
        } catch (Exception e) {
            System.out.println("Incorrect input");
        }
        return selectedAnimal;
    }
}
