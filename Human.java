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
