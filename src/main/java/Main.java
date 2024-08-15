import daos.Person;

public class Main {


    public static void main(String[] args) {
        Person person = new Person();
        Person eyan = new Person(5,"Jeffrey", "Eyan", "New Place", "New City!");
        person.update(eyan);
    }
}
