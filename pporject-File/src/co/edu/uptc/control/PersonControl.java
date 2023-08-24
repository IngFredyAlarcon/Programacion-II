package co.edu.uptc.control;

import co.edu.uptc.model.Person;

public class PersonControl {
    private Person p;
    private FileManagementControl fmc;

    public boolean addPerson(String firstName, String lastName, int age) {
        p = new Person();

        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setAge(age);

        if (p.getFirstName().equals(firstName) && p.getLastName().equals(lastName) && p.getAge() == age) {
            return true;
        } else {
            return false;
        }

    }

    public boolean saveInformationPerson(String fileName, String data) {
        fmc = new FileManagementControl();
        if (fmc.createFile(fileName)) {
            fmc.writeFile(fileName, data);
            return true;
        } else {
            return false;
        }
    }

    public String showInformationPerson() {
        return p.toString();
    }

    // public String read
}
