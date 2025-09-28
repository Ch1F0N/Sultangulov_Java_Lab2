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
