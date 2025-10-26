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
