import java.util.List;

public class Directory {
    int id;
    List<Person> listPersons;

    public Directory(int id, List<Person> listPersons) {
        this.id = id;
        this.listPersons = listPersons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Person> getListPersons() {
        return listPersons;
    }

    public void setListPersons(List<Person> listPersons) {
        this.listPersons = listPersons;
    }

    @Override
    public String toString() {
        return "Directory [id=" + id + ", listPersons=" + listPersons + "]";
    }
}
