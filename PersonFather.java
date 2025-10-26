public class PersonFather {
    private Human human;
    private PersonFather father;

    public PersonFather(Human human, PersonFather father) {
        this.human = human;
        this.father = null;
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
