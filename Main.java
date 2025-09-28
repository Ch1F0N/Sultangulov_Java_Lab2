import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Меню заданий:\n" +
                        "1. Имена\n" +
                        "2. Человек с именем\n" +
                        "3. Человек с родителем\n" +
                        "4. Ломаная\n" +
                        "5. Создаём Ломаную\n" +
                        "6. Длина ломаной\n" +
                        "0. Выход\n");

                System.out.print("Выберите задание из меню, которое хотите запустить: ");
                int task_menu = scanner.nextInt();
                System.out.println();

                if (task_menu == 0) {
                    break;
                }

                switch (task_menu) {
                    // Имена
                    case 1:
                        int countNames = CheckInput.readInt(scanner, "Введите кол-во людей, чьё ФИО хотите написать: ", 0);
                        ArrayList<String> namesList = new ArrayList<>(countNames);

                        for (int i = 1; i <= countNames; i++){
                            System.out.println(i + ")");
                            String lastName = CheckInput.readString(scanner, "Введите фамилию (Enter - без): ");
                            String name = CheckInput.readString(scanner, "Введите имя (Enter - без): ");
                            String midName = CheckInput.readString(scanner, "Введите отчество (Enter - без): ");

                            if (!lastName.isEmpty() || !name.isEmpty() || !midName.isEmpty()) {
                                CheckInput.checkEmptyNames(namesList, lastName, name, midName);
                            }

                            System.out.println("\nСписок всех ФИО:");
                            if (namesList.isEmpty()) {
                                System.out.println("Все элементы списка пустые!");
                            }

                            for (int el = 0; el < namesList.size(); el++) {
                                System.out.println(el + 1 + ") " + namesList.get(el));
                            }
                        }

                        System.out.println();
                        break;

                    case 2:
                        // Человек с именем
                        int countNames2 = CheckInput.readInt(scanner, "Введите кол-во людей, чьё ФИО и рост хотите написать: ", 0);
                        ArrayList<String> humansList = new ArrayList<>(countNames2);
                        int height = 0;

                        for (int i = 1; i <= countNames2; i++){
                            System.out.println(i + ")");
                            String lastName = CheckInput.readString(scanner, "Введите фамилию (Enter - без): ");
                            String name = CheckInput.readString(scanner, "Введите имя (Enter - без): ");
                            String midName = CheckInput.readString(scanner, "Введите отчество (Enter - без): ");

                            if (!lastName.isEmpty() || !name.isEmpty() || !midName.isEmpty()) {
                                height = CheckInput.readInt(scanner, "Введите рост человека: ", 0);
                                CheckInput.checkEmptyHumans(humansList, lastName, name, midName, height);
                            }

                            System.out.println("\nСписок всех ФИО и их роста:");
                            if (humansList.isEmpty()) {
                                System.out.println("Все элементы списка пустые!");
                            }

                            for (int el = 0; el < humansList.size(); el++) {
                                System.out.println(el + 1 + ") " + humansList.get(el) + " см.");
                            }
                        }

                        System.out.println();
                        break;

                    case 3:
                        // Человек с родителем
                        PersonFather ivan = new PersonFather(new Name("Чудов", "Иван", null));
                        PersonFather petr = new PersonFather(new Name("Чудов", "Петр", null));
                        PersonFather boris = new PersonFather(new Name(null, "Борис", null));

                        petr.setFather(ivan);
                        boris.setFather(petr);

                        System.out.println(ivan);
                        System.out.println(petr);
                        System.out.println(boris);
                        System.out.println();
                        break;

                    case 4:
                        // Ломаная
                        BrokenLine firstLine1 = new BrokenLine(1, 5);
                        BrokenLine firstLine2 = new BrokenLine(2, 8);
                        BrokenLine firstLine3 = new BrokenLine(5, 3);

                        String firstLine = firstLine1 + ", "
                                + firstLine2 + ", "
                                + firstLine3;

                        System.out.println("Первая ломаная: " + firstLine);

                        BrokenLine secondLine1 = firstLine1;
                        BrokenLine secondLine2 = new BrokenLine(2, -5);
                        BrokenLine secondLine3 = new BrokenLine(4, -8);
                        BrokenLine secondLine4 = firstLine3;

                        String secondLine = secondLine1 + ", "
                                + secondLine2 + ", "
                                + secondLine3 + ", "
                                + secondLine4;

                        System.out.println("Вторая ломаная: " + secondLine);

                        System.out.println("Сдвигаем начало первой ломаной...");
                        firstLine1.movePoint();

                        firstLine = firstLine1 + ", "
                                + firstLine2 + ", "
                                + firstLine3;
                        secondLine = secondLine1 + ", "
                                + secondLine2 + ", "
                                + secondLine3 + ", "
                                + secondLine4;

                        System.out.println("Первая ломаная: " + firstLine);
                        System.out.println("Вторая ломаная: " + secondLine);
                        System.out.println();
                        break;

                    case 5:
                        // Создаём Ломаную
                        BrokenLineEx9 emptyLine = new BrokenLineEx9();
                        BrokenLineEx9 someLine = new BrokenLineEx9(2, 8, 3, -4);
                        BrokenLineEx9 point = new BrokenLineEx9(9, 4);

                        System.out.println("Ломаная без указания параметров: " + emptyLine);
                        System.out.println("Ломаная с указанием некоторого набора точек (2): " + someLine);
                        System.out.println("Одна точка: " + point);
                        System.out.println();
                        break;

                    case 6:
                        // Длина ломаной
                        System.out.println("Это задание находится на стадии разработки...");
                        break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Вы должны ввести только целое число!");
                System.out.println();
            }
        }
    }
}