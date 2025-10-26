import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
                        }

                        System.out.println("\nСписок всех ФИО:");
                        if (namesList.isEmpty()) {
                            System.out.println("Все элементы списка пустые!");
                        }

                        for (int el = 0; el < namesList.size(); el++) {
                            System.out.println(el + 1 + ") " + namesList.get(el));
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
                        }

                        System.out.println("\nСписок всех ФИО и их роста:");
                        if (humansList.isEmpty()) {
                            System.out.println("Все элементы списка пустые!");
                        }

                        for (int el = 0; el < humansList.size(); el++) {
                            System.out.println(el + 1 + ") " + humansList.get(el) + " см.");
                        }

                        System.out.println();
                        break;

                    case 3:
                        System.out.println("Создание людей:");

                        PersonFather ivan = new PersonFather(new Human(new Name("Чудов", "Иван", null), 175), null);
                        PersonFather petr = new PersonFather(new Human(new Name("Чудов", "Петр", null), 180), null);
                        PersonFather boris = new PersonFather(new Human(new Name(null, "Борис", null), 170), null);

                        petr.setFather(ivan);
                        boris.setFather(petr);

                        System.out.println("\nРезультат:");
                        System.out.println("1) " + ivan);
                        System.out.println("2) " + petr);
                        System.out.println("3) " + boris);
                        System.out.println();
                        break;

                    case 4:
                        // Точки первой ломаной
                        Point a1 = new Point(1, 5);
                        Point a2 = new Point(2, 8);
                        Point a3 = new Point(5, 3);
                        BrokenLine line1 = new BrokenLine(a1, a2, a3);

                        // Точки второй ломаной
                        Point b1 = a1;
                        Point b2 = new Point(2, -5);
                        Point b3 = new Point(4, -8);
                        Point b4 = a3;
                        BrokenLine line2 = new BrokenLine(b1, b2, b3, b4);

                        System.out.println("Исходные ломаные:");
                        System.out.println("1) " + line1);
                        System.out.println("2) " + line2);

                        // Сдвигаем начало первой ломаной
                        double dx = 3;
                        double dy = -2;
                        System.out.println("\nСдвигаем начало первой ломаной на (" + dx + ", " + dy + ")...");
                        a1.move(dx, dy);

                        System.out.println("\nПосле сдвига:");
                        System.out.println("1) " + line1);
                        System.out.println("2) " + line2);
                        System.out.println();
                        break;


                    case 5:
                        BrokenLineEx9 emptyLine = new BrokenLineEx9();

                        BrokenLineEx9 someLine = new BrokenLineEx9(
                                new Point(2, 8),
                                new Point(3, -4)
                        );

                        BrokenLineEx9 singlePointLine = new BrokenLineEx9(new Point(9, 4));

                        System.out.println("Ломаная без указания параметров: " + emptyLine);
                        System.out.println("Ломаная с указанием некоторого набора точек (2): " + someLine);
                        System.out.println("Одна точка: " + singlePointLine);
                        System.out.println();
                        break;

                    case 6:
                        BrokenLineEx7 line = new BrokenLineEx7(
                                new Point(1, 5),
                                new Point(2, 8),
                                new Point(5, 3)
                        );

                        System.out.println("Ломаная: " + line);

                        System.out.printf("Длина ломаной: %.2f%n", line.getLength());

                        line.addPoints(new Point(5, 15), new Point(8, 10));

                        System.out.println("\nПосле добавления точек:");
                        System.out.println("Ломаная: " + line);
                        System.out.printf("Новая длина: %.2f%n", line.getLength());
                        System.out.println();
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