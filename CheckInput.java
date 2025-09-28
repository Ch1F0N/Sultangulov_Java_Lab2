import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckInput {
    public static String readString(Scanner scanner, String userInput) {
        while (true) {
            System.out.print(userInput);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                return "";
            }

            if (input.matches("[A-Za-zА-Яа-яЁ-ё]+")) {
                if (CheckInput.isProperCase(input)) {
                    return input;
                } else {
                    System.out.println("Вы должны вводить ФИО с большой буквы, а остальные буквы маленькими!");
                }
            } else {
                System.out.println("Вы должны вводить только буквы!");
            }
        }
    }

    public static int readInt(Scanner scanner, String message, int userInput) {
        while (true) {
            try {
                System.out.print(message);
                int input = scanner.nextInt();

                if (input <= 0) {
                    System.out.println("Вы должны ввести целое число > 0!");
                } else {
                    scanner.nextLine();
                    return input;
                }
            } catch (InputMismatchException e) {
                System.out.println("Вы должны ввести целое число > 0!");
                break;
            }
        }
        return userInput;
    }

    // Проверка на ввод ФИО с большой буквы и остальные буквы маленькими
    public static boolean isProperCase(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        if(!Character.isUpperCase(str.charAt(0))) {
            return false;
        }

        for(int i = 1; i < str.length(); i++) {
            if(!Character.isLowerCase(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static ArrayList<String> checkEmptyNames(ArrayList<String> namesList, String lastName, String name, String midName) {
        if (lastName.isEmpty()) {
            if (name.isEmpty() && midName.isEmpty()) {
                return null;
            } else if (midName.isEmpty()) {
                Name names = new Name(name);
                namesList.add(String.valueOf(names));
            } else if (name.isEmpty()) {
                Name names = new Name(midName);
                namesList.add(String.valueOf(names));
            } else {
                Name names = new Name(name, midName);
                namesList.add(String.valueOf(names));
            }
        } else if (name.isEmpty()) {
            if (midName.isEmpty()) {
                Name names = new Name(lastName);
                namesList.add(String.valueOf(names));
            } else {
                Name names = new Name(lastName, midName);
                namesList.add(String.valueOf(names));
            }
        } else if (midName.isEmpty()) {
            Name names = new Name(lastName, name);
            namesList.add(String.valueOf(names));
        } else {
            Name names = new Name(lastName, name, midName);
            namesList.add(String.valueOf(names));
        }
        return namesList;
    }

    public static ArrayList<String> checkEmptyHumans(ArrayList<String> humansList, String lastName, String name, String midName, int height) {
        if (lastName.isEmpty()) {
            if (name.isEmpty() && midName.isEmpty()) {
                return null;
            } else if (midName.isEmpty()) {
                Human humans = new Human(name, height);
                humansList.add(String.valueOf(humans));
            } else if (name.isEmpty()) {
                Human humans = new Human(midName, height);
                humansList.add(String.valueOf(humans));
            } else {
                Human humans = new Human(name, midName, height);
                humansList.add(String.valueOf(humans));
            }
        } else if (name.isEmpty()) {
            if (midName.isEmpty()) {
                Human humans = new Human(lastName, height);
                humansList.add(String.valueOf(humans));
            } else {
                Human humans = new Human(lastName, midName, height);
                humansList.add(String.valueOf(humans));
            }
        } else if (midName.isEmpty()) {
            Human humans = new Human(lastName, name, height);
            humansList.add(String.valueOf(humans));
        } else {
            Human humans = new Human(lastName, name, midName, height);
            humansList.add(String.valueOf(humans));
        }
        return humansList;
    }
}
