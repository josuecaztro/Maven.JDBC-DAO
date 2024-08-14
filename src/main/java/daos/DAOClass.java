package daos;

import java.util.List;

public class DAOClass implements DAO {

    private int personID;
    private String lastName;
    private String firstName;
    private String address;
    private String city;

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public List findAll() {
        return List.of();
    }

    @Override
    public Object update(Object dto) {
        return null;
    }

    @Override
    public Object create(Object dto) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

}
