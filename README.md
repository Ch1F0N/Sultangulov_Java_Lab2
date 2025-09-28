# Лабораторная работа №2 ЯП Java
**Султангулов Данил**

**Группа ИТ-9-2024 (2 курс)**

**Вариант №10**

---

# Тема: Объектно-ориентированное программирование (ООП)

Сперва я создал в своей лабораторной работе меню со всеми задания от 1 до 20, а также разделил их все на категории, чтобы пользователю было удобно выбирать, какую именно из программ он хочет использовать:
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
    StringBuilder sb = new StringBuilder();
    private String lastName;
    private String name;
    private String midName;

    public Name() {
        this.lastName = "Дуров";
        this.name = "Павел";
        this.midName = "Валерьевич (Человек по умолчанию)";
    }

    public Name(String lastName, String name, String midName) {
        this.lastName = lastName;
        this.name = name;
        this.midName = midName;
    }

    public Name(String lastName, String name) {
        this.lastName = lastName;
        this.name = name;
    }

    public Name(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getMidName() {
        return midName;
    }

    public String toString() {
        if (lastName != null && !lastName.isEmpty()) {
            sb.append(lastName);
        }
        if (name != null && !name.isEmpty()) {
            if (!sb.isEmpty()) sb.append(" ");
            sb.append(name);
        }
        if (midName != null && !midName.isEmpty()) {
            if (!sb.isEmpty()) sb.append(" ");
            sb.append(midName);
        }

        return sb.toString();
    }
}
```
В классе я использовал перегрузку конструкторов, всего их в классе **Name** 4 разных вида, один из который по умолчанию (В своём коде я его не использую, создавал его для понимания в дальнейшем):
```java
public Name() {
    this.lastName = "Дуров";
    this.name = "Павел";
    this.midName = "Валерьевич (Человек по умолчанию)";
}

public Name(String lastName, String name, String midName) {
    this.lastName = lastName;
    this.name = name;
    this.midName = midName;
}

public Name(String lastName, String name) {
    this.lastName = lastName;
    this.name = name;
}

public Name(String name) {
    this.name = name;
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
    if (lastName != null && !lastName.isEmpty()) {
        sb.append(lastName);
    }
    if (name != null && !name.isEmpty()) {
        if (!sb.isEmpty()) sb.append(" ");
        sb.append(name);
    }
    if (midName != null && !midName.isEmpty()) {
        if (!sb.isEmpty()) sb.append(" ");
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
public class Human extends Name {
    StringBuilder sb = new StringBuilder();
    private String lastName2;
    private String name2;
    private String midName2;
    private int height;

    public Human() {
        this.lastName2 = "Дуров";
        this.name2 = "Павел";
        this.midName2 = "Валерьевич (Человек по умолчанию)";
        this.height = 152;
    }

    public Human(String lastName2, String name2, String midName2, int height) {
        this.lastName2 = lastName2;
        this.name2 = name2;
        this.midName2 = midName2;
        this.height = height;
    }

    public Human(String lastName2, String name2, int height) {
        this.lastName2 = lastName2;
        this.name2 = name2;
        this.height = height;
    }

    public Human(String name2, int height) {
        this.name2 = name2;
        this.height = height;
    }

    public String toString() {
        if (lastName2 != null && !lastName2.isEmpty()) {
            sb.append(lastName2);
        }
        if (name2 != null && !name2.isEmpty()) {
            if (!sb.isEmpty()) sb.append(" ");
            sb.append(name2);
        }
        if (midName2 != null && !midName2.isEmpty()) {
            if (!sb.isEmpty()) sb.append(" ");
            sb.append(midName2);
        }

        return sb.append(" и ростом ").append(height).toString();
    }
}
```
В этой сущности почти нет отличий от прошлой **Name**, кроме добавления нового параметра 'height' и вывода из перегруженного метода **toString()**:
```java
return sb.append(" и ростом ").append(height).toString();
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
    private Name name;
    private PersonFather father;

    public PersonFather(Name name) {
        this.name = name;
    }

    public void setFather(PersonFather father) {
        this.father = father;
    }

    @Override
    public String toString() {
        String lastName = name.getLastName();
        String firstName = name.getName();
        String midName = name.getMidName();

        if (lastName == null || lastName.isEmpty()
                && father != null
                && father.name != null
                && father.name.getLastName() != null) {
            lastName = father.name.getLastName();
        }
        if (midName == null || midName.isEmpty()) {
            if (father != null && father.name != null && father.name.getName() != null) {
                midName = father.name.getName() + "ович";
            } else {
                midName = "";
            }
        }

        return new Name(lastName, firstName, midName).toString();
    }
}
```
В нём всего один конструктор с одним параметром 'name', который содержит в себе объект класса **Name**, а то есть ФИО и метод **setFather()**, который задаёт отца для создаваемого объекта:
```java
public PersonFather(Name name) {
    this.name = name;
}

public void setFather(PersonFather father) {
    this.father = father;
}
```
Перегрузка метода **toString()**, в которой созданы 3 поля ФИО: 'lastName', 'firstName', 'midName' (как раз для этих полей были сделаны геттеры в первом задании), для последующей проверки, в конце возвращаем строку объекта класса **Name**:
```java
@Override
public String toString() {
    String lastName = name.getLastName();
    String firstName = name.getName();
    String midName = name.getMidName();

    if (lastName == null || lastName.isEmpty()
            && father != null
            && father.name != null
            && father.name.getLastName() != null) {
        lastName = father.name.getLastName();
    }
    if (midName == null || midName.isEmpty()) {
        if (father != null && father.name != null && father.name.getName() != null) {
            midName = father.name.getName() + "ович";
        } else {
            midName = "";
        }
    }

    return new Name(lastName, firstName, midName).toString();
}
```
> Метод можно доработать, чтобы в зависимости от имени отца зависело окончание отчества его ребёнка, а также разность полов.

---
**Реализуем ввод**
Так как возникли трудности, то программа работает без пользовательского ввода, весь ввод реализован в самом коде:
```java
PersonFather ivan = new PersonFather(new Name("Чудов", "Иван", null));
PersonFather petr = new PersonFather(new Name("Чудов", "Петр", null));
PersonFather boris = new PersonFather(new Name(null, "Борис", null));

petr.setFather(ivan);
boris.setFather(petr);

System.out.println(ivan);
System.out.println(petr);
System.out.println(boris);
```
---

## Задача 4:
> **Задача 4 заключается в том, чтобы создать сущность Ломаная, которая будет выводить все точки двух ломаных**

Для выполнения этого задания я создал класс-сущность **BrokenLine**:
```java
public class BrokenLine {
    private int x;
    private int y;

    public BrokenLine(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void movePoint() {
        this.x += 2;
        this.y -= 5;
    }

    @Override
    public String toString() {
        return String.format("{%1$d;%2$d}", x, y);
    }
}
```
Конструктор **BrokenLine()**, где присваиваются значения 'x' и 'y', и метод **movePoint()**, который сдвигает координаты точки (в данном случае 'x' сдвигается вперёд на 2, а 'y' вниз на 5):
```java
public BrokenLine(int x, int y) {
    this.x = x;
    this.y = y;
}

public void movePoint() {
    this.x += 2;
    this.y -= 5;
}
```
Перегрузка метода **toString()** выводит строку типа: {x;y}:
```java
@Override
public String toString() {
    return String.format("{%1$d;%2$d}", x, y); // %d заменяется на переменные с целыми числами x, y, n$ обозначает, какая именно по счёту должна стоять переменная на этом месте
}
```

---
**Реализуем пользовательский ввод**
```java
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
```
---

## Задача 5:
> **Задача 5 заключается в том, чтобы изменить сущность Ломаная из прошлого задания и дать ей возможность создавать объект без параметром или с несколькими значениями**

Для выполнения этого задания я создал класс-сущность **BrokenLineEx9** 'Ex9' - номер задания:
```java
public class BrokenLineEx9 {
    private int x;
    private int y;
    private int x2;
    private int y2;

    public BrokenLineEx9() {
        this.x = 0;
        this.y = 0;
    }

    public BrokenLineEx9(int x, int y, int x2, int y2) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
    }

    public BrokenLineEx9(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void movePoint() {
        this.x += 2;
        this.y -= 5;
    }

    @Override
    public String toString() {
        if (x2 != 0 && y2 != 0) {
            return String.format("{%1$d;%2$d}, {%3$d;%4$d}", x, y, x2, y2);
        } else {
            return String.format("{%1$d;%2$d}", x, y);
        }
    }
}
```
В новой сущности я перегрузил 2 конструктора **BrokenLineEx9**, где первый по умолчанию, т.е объект создаётся даже без параметров и другой, где задаются координаты сразу двух точек:
```java
public BrokenLineEx9() {
    this.x = 0;
    this.y = 0;
}

public BrokenLineEx9(int x, int y, int x2, int y2) {
    this.x = x;
    this.y = y;
    this.x2 = x2;
    this.y2 = y2;
}
```
Перегрузил метод **toString()**, в котором теперь проверяется, ввёл пользователь сразу координаты двух точек или только одной:
```java
@Override
public String toString() {
    if (x2 != 0 && y2 != 0) {
        return String.format("{%1$d;%2$d}, {%3$d;%4$d}", x, y, x2, y2);
    } else {
        return String.format("{%1$d;%2$d}", x, y);
    }
}
```

---
**Реализуем пользовательский ввод**
```java
BrokenLineEx9 emptyLine = new BrokenLineEx9();
BrokenLineEx9 someLine = new BrokenLineEx9(2, 8, 3, -4);
BrokenLineEx9 point = new BrokenLineEx9(9, 4);

System.out.println("Ломаная без указания параметров: " + emptyLine);
System.out.println("Ломаная с указанием некоторого набора точек (2): " + someLine);
System.out.println("Одна точка: " + point);
```
---

# Защита от ошибок
Для защиты от неверного ввода используется конструкция **try-catch**.
