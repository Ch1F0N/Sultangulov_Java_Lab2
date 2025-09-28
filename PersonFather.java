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
