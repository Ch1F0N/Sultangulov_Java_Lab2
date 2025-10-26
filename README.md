# Лабораторная работа №2 ЯП Java
**Султангулов Данил**

**Группа ИТ-9-2024 (2 курс)**

**Вариант №10**

---

# Тема: Объектно-ориентированное программирование (ООП)

Сперва я создал в своей лабораторной работе меню со всеми задания от 1 до 6, а также разделил их все на категории, чтобы пользователю было удобно выбирать, какую именно из программ он хочет использовать:
```java
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
```

Если пользователь введёт номер, которого нет в меню, или введёт иные символы, то в терминале вылезет предупреждение о неверном вводе и меню запуститься заново, чтобы выйти из программы, пользователю достаточно ввести в терминал '0'. Для запуска конкретной программы, я решил использовать конструкцию swith-case.

---

## Задание 1 (№3):
> **Задача №3 заключается в том, чтобы создать сущность Имя, которое будет иметь 3 параметра: Фамилия, Имя, Отчество и вывести их на экран**

Для выполнения этого задания я создал класс-сущность **Name**:
```java
class Name {
    private String lastName;
    private String name;
    private String midName;

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getMidName() {
        return midName;
    }

    public Name() {
        this.lastName = null;
        this.name = null;
        this.midName = null;
    }

    public Name(String lastName, String name, String midName) {
        this.lastName = lastName;
        this.name = name;
        this.midName = midName;
    }

    public Name(String lastName, String name) {
        this.lastName = lastName;
        this.name = name;
        this.midName = null;
    }

    public Name(String name) {
        this.lastName = null;
        this.name = name;
        this.midName = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (lastName != null && !lastName.isEmpty()) sb.append(lastName);
        if (name != null && !name.isEmpty()) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(name);
        }
        if (midName != null && !midName.isEmpty()) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(midName);
        }
        return sb.toString();
    }
}
```
В классе я использовал перегрузку конструкторов, всего их в классе **Name** 4 разных вида, один из который по умолчанию (В своём коде я его не использую, создавал его для понимания в дальнейшем):
```java
public Name() {
        this.lastName = null;
        this.name = null;
        this.midName = null;
    }

public Name(String lastName, String name, String midName) {
    this.lastName = lastName;
    this.name = name;
    this.midName = midName;
}

public Name(String lastName, String name) {
    this.lastName = lastName;
    this.name = name;
    this.midName = null;
}

public Name(String name) {
    this.lastName = null;
    this.name = name;
    this.midName = null;
}
```
Создал геттеры для получения ФИО по отдельности, создавал я их для выполнения одного из следующих заданий, так как для решения первого я уже пользовался другим способом:
```java
public String getLastName() {
    return lastName;
}

public String getName() {
    return name;
}

public String getMidName() {
    return midName;
}
```
Далее я делаю перегрузку метода **toString()**, для того, чтобы вывод строки был таким, каким я его хочу:
```java
public String toString() {
    StringBuilder sb = new StringBuilder();
    if (lastName != null && !lastName.isEmpty()) sb.append(lastName);
    if (name != null && !name.isEmpty()) {
        if (sb.length() > 0) sb.append(" ");
        sb.append(name);
    }
    if (midName != null && !midName.isEmpty()) {
        if (sb.length() > 0) sb.append(" ");
        sb.append(midName);
    }
    return sb.toString();
}
```
Здесь, я проверяю, не пустые ли метод получил параметры, если это так, то добавляем их в строку при помощи метода класса **StringBuilder**, после всех проверок возвращаем итоговую строку.
```java
return sb.toString();
```

---
**Реализуем пользовательский ввод**
```java
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
```
Здесь я задаю новую переменную 'countNames' - она отвечает за кол-во ФИО, которое хочет ввести пользователь читаю и проверяю значение я при помощи моего метода **readInt()**, о котором я напишу позже
```java
int countNames = CheckInput.readInt(scanner, "Введите кол-во людей, чьё ФИО хотите написать: ", 0);
```
Далее задаю список, в котором буду хранить все полученные ФИО:
```java
ArrayList<String> namesList = new ArrayList<>(countNames);
```
Затем запускаю цикл, который работает, пока вспомогательная переменная i не будет равна переменной 'countNames' и запрашиваю у пользователя ввод ФИО по очереди, в нём я также проверяю значения с помощью метода **readString()**, и, если хотя бы один из элементов не пустой, то вызываю метод **checkEmptyNames()**, который получает на вход список и заданные параметры, об этих методах я напишу позже:
```java
for (int i = 1; i <= countNames; i++){
    System.out.println(i + ")");
    String lastName = CheckInput.readString(scanner, "Введите фамилию (Enter - без): ");
    String name = CheckInput.readString(scanner, "Введите имя (Enter - без): ");
    String midName = CheckInput.readString(scanner, "Введите отчество (Enter - без): ");

    if (!lastName.isEmpty() || !name.isEmpty() || !midName.isEmpty()) {
        CheckInput.checkEmptyNames(namesList, lastName, name, midName);
    }
}
```
После ввода всех значений формирую вывод итогового списка в терминал:
```java
System.out.println("\nСписок всех ФИО:");
if (namesList.isEmpty()) {
    System.out.println("Все элементы списка пустые!"); // Если в списке все полученные элементы оказались пустыми - сообщаем об этом
}

for (int el = 0; el < namesList.size(); el++) {
    System.out.println(el + 1 + ") " + namesList.get(el)); // Если у нас есть хоть одно значение - выводим список и нумеруем каждое ФИО
}
```
**Реализуем отдельный класс с проверками**
Для проверки значений, которые вводит пользователь я создал отдельный класс **CheckInput()**, в котором будут храниться методы для чтения и проверки, выглядит он следующим образом:
```java
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
```
Метод **readString()** проверяет строку, которую вводит пользователь, чтобы она состояла только из букв англ. и рус. алфавита, так как этот метод используется только для создания объектов с ФИО - проверяем, чтобы ФИО начиналось с большой буквы, а все послудующие буквы были маленькими:
```java
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
```
Для проверки на размер букв я создал отдельный булевой(true/false) метод **isProperCase()**:
```java
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
```
Метод **readInt()** проверяет число и так как используется оно только в случаях, когда число не должно быть меньше 0, добавляю в него проверку (в будущем можно переделать этот метод, чтобы использовать его и в других заданиях с пользовательским вводом, например в задании с **Ломаной**, где пользовательский ввод не был реализован):
```java
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
```
Метод **CheckEmptyNames()** используется только для первого задания, он создан для того, чтобы проверять пустые элементы, если они не пустые - то создаём новый объект класса **Name**, который добавляем в наш список и возвращаем его после всех проверок:
```java
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
```

---

## Задача 2:
> **Задача 2 заключается в том, чтобы создать создать сущность Человек с именем, где в выводе должно получиться ФИО и рост человека**

Для выполнения этого задания я создал класс-сущность **Human**:
```java
public class Human {
    private Name name;
    private int height;

    public Human(Name name, int height) {
        this.name = name;
        this.height = height;
    }

    public Name getNameObj() {
        return name;
    }

    public String getLastName() {
        return name.getLastName();
    }

    public String getName() {
        return name.getName();
    }

    public String getMidName() {
        return name.getMidName();
    }

    @Override
    public String toString() {
        if (name != null) {
            String n = name.toString();
            return n + " (рост " + height + " см)";
        } else {
            return "Неизвестно";
        }
    }
}
```
---

**Реализуем пользовательский ввод**
```java
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
```
Здесь также отличие только в новом параметре height, но в качестве проверки на пустые элементы создал новый метод **checkEmptyHumans()**, который будет внутри себя создавать объекты класса **Human** и возвращать список.

---

## Задача 3:
> **Задача 3 заключается в том, чтобы создать сущность Человек с родителем, где у человека будет ещё и отец**

Для выполнения этого задания я создал класс сущность **PersonFather**:
```java
public class PersonFather {
    private Human human;
    private PersonFather father;

    public PersonFather(Human human) {
        this.human = human;
    }

    public void setFather(PersonFather father) {
        this.father = father;
    }

    @Override
    public String toString() {
        if (human == null) {
            return "Неизвестный человек";
        }

        String lastName = human.getLastName();
        String firstName = human.getName();
        String midName = human.getMidName();

        if ((lastName == null || lastName.isEmpty()) && father != null && father.human != null) {
            lastName = father.human.getLastName();
        }

        if ((midName == null || midName.isEmpty()) && father != null && father.human != null) {
            String fatherName = father.human.getName();
            if (fatherName != null && !fatherName.isEmpty()) {
                midName = fatherName + "ович";
            }
        }

        String result = "";

        if (lastName != null && !lastName.isEmpty()) {
            result += lastName;
        }

        if (firstName != null && !firstName.isEmpty()) {
            if (!result.isEmpty()) result += " ";
            result += firstName;
        }

        if (midName != null && !midName.isEmpty()) {
            if (!result.isEmpty()) result += " ";
            result += midName;
        }

        // Если все поля пустые
        if (result.isEmpty()) {
            result = "Неизвестный человек";
        }

        return result;
    }
}
```
В нём всего один конструктор с одним параметром 'name', который содержит в себе объект класса **Human**, а то есть ФИО и метод **setFather()**, который задаёт отца для создаваемого объекта:
```java
public PersonFather(Human human) {
    this.human = human;
}

public void setFather(PersonFather father) {
    this.father = father;
}
```
Перегрузка метода **toString()**
```java
@Override
public String toString() {
    if (human == null) {
        return "Неизвестный человек";
    }

    String lastName = human.getLastName();
    String firstName = human.getName();
    String midName = human.getMidName();

    if ((lastName == null || lastName.isEmpty()) && father != null && father.human != null) {
        lastName = father.human.getLastName();
    }

    if ((midName == null || midName.isEmpty()) && father != null && father.human != null) {
        String fatherName = father.human.getName();
        if (fatherName != null && !fatherName.isEmpty()) {
            midName = fatherName + "ович";
        }
    }

    String result = "";

    if (lastName != null && !lastName.isEmpty()) {
        result += lastName;
    }

    if (firstName != null && !firstName.isEmpty()) {
        if (!result.isEmpty()) result += " ";
        result += firstName;
    }

    if (midName != null && !midName.isEmpty()) {
        if (!result.isEmpty()) result += " ";
        result += midName;
    }

    // Если все поля пустые
    if (result.isEmpty()) {
        result = "Неизвестный человек";
    }

    return result;
}
```
> Метод можно доработать, чтобы в зависимости от имени отца зависело окончание отчества его ребёнка, а также разность полов.

---
**Реализуем ввод**
Так как возникли трудности, то программа работает без пользовательского ввода, весь ввод реализован в самом коде:
```java
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
```
---

## Задача 4:
> **Задача 4 заключается в том, чтобы создать сущность Ломаная, которая будет выводить все точки двух ломаных**

Для выполнения этого задания я создал класс-сущность **Point**:
```java
public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}
```
И класс-сущность **BrokenLine**:
```java
public class BrokenLine {
    private Point[] points;

    public BrokenLine(Point... points) {
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    public void move(double dx, double dy) {
        for (Point p : points) {
            p.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Линия [");
        for (int i = 0; i < points.length; i++) {
            sb.append(points[i]);
            if (i < points.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
```
Перегрузка метода **toString()** выводит строку типа: {x;y}:
```java
@Override
public String toString() {
    StringBuilder sb = new StringBuilder("Линия [");
    for (int i = 0; i < points.length; i++) {
        sb.append(points[i]);
        if (i < points.length - 1) sb.append(", ");
    }
    sb.append("]");
    return sb.toString();
}
```

---
**Реализуем пользовательский ввод**
```java
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
```
---

## Задача 5:
> **Задача 5 заключается в том, чтобы изменить сущность Ломаная из прошлого задания и дать ей возможность создавать объект без параметром или с несколькими значениями**

Для выполнения этого задания я создал класс-сущность **BrokenLineEx9** 'Ex9' - номер задания:
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrokenLineEx9 {
    private List<Point> points;

    public BrokenLineEx9() {
        this.points = new ArrayList<>();
    }

    public BrokenLineEx9(Point... points) {
        this.points = new ArrayList<>(Arrays.asList(points));
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public List<Point> getPoints() {
        return points;
    }

    public void move(double dx, double dy) {
        for (Point p : points) {
            p.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        if (points.isEmpty()) return "Линия []";
        StringBuilder sb = new StringBuilder("Линия [");
        for (int i = 0; i < points.size(); i++) {
            sb.append(points.get(i));
            if (i < points.size() - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
```
В новой сущности я перегрузил 2 конструктора **BrokenLineEx9**, где первый по умолчанию, т.е объект создаётся даже без параметров и другой, где задаются координаты произвольного кол-ва точек:
```java
public BrokenLineEx9() {
    this.points = new ArrayList<>();
}

public BrokenLineEx9(Point... points) {
    this.points = new ArrayList<>(Arrays.asList(points));
}
```
Перегрузка метода **toString()**:
```java
@Override
public String toString() {
    if (points.isEmpty()) {
        return "Линия []";
    }
    StringBuilder sb = new StringBuilder("Линия [");
    for (int i = 0; i < points.size(); i++) {
        sb.append(points.get(i));
        if (i < points.size() - 1) sb.append(", ");
    }
    sb.append("]");
    return sb.toString();
}
```

---
**Реализуем пользовательский ввод**
```java
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
```
---

## Задача 6:
> **Задача 6 заключается в том, чтобы изменить сущность Ломаная из прошлого задания и дать ей возможность добавлять к уже имеющимся точкам - новые точки и возращать длину Ломаной**

Для выполнения этого задания я создал класс-сущность **BrokenLineEx7** 'Ex7' - номер задания:
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrokenLineEx7 {
    private List<Point> points;

    public BrokenLineEx7() {
        this.points = new ArrayList<>();
    }

    public BrokenLineEx7(Point... points) {
        this.points = new ArrayList<>(Arrays.asList(points));
    }

    public void addPoint(Point point) {
        if (point != null) {
            points.add(point);
        }
    }

    public void addPoints(Point... newPoints) {
        points.addAll(Arrays.asList(newPoints));
    }

    public double getLength() {
        if (points.size() < 2) return 0.0;

        double length = 0.0;
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            double dx = p2.getX() - p1.getX();
            double dy = p2.getY() - p1.getY();
            length += Math.sqrt(dx * dx + dy * dy);
        }
        return length;
    }

    public void move(double dx, double dy) {
        for (Point p : points) {
            p.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        if (points.isEmpty()) {
            return "Линия []";
        }
        StringBuilder sb = new StringBuilder("Линия [");
        for (int i = 0; i < points.size(); i++) {
            sb.append(points.get(i));
            if (i < points.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
```
Перегрузка метода **toString()**:
```java
@Override
public String toString() {
    if (points.isEmpty()) {
        return "Линия []";
    }
    StringBuilder sb = new StringBuilder("Линия [");
    for (int i = 0; i < points.size(); i++) {
        sb.append(points.get(i));
        if (i < points.size() - 1) {
            sb.append(", ");
        }
    }
    sb.append("]");
    return sb.toString();
}
```
---
**Реализуем пользовательский ввод**
```java
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
```

---

# Защита от ошибок
Для защиты от неверного ввода используется конструкция **try-catch**.
