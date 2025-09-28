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
