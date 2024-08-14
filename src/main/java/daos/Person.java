package daos;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Person implements DAO {

    private int personID;
    private String lastName;
    private String firstName;
    private String address;
    private String city;

    public Person(){
    }

    //constructor without ID - for good practice
    public Person(String last, String first, String add, String city){
        this.lastName = last;
        this.firstName = first;
        this.address = add;
        this.city = city;
    }

    public Person(int id, String last, String first, String add, String city){
        this.personID = id;
        this.lastName = last;
        this.firstName = first;
        this.address = add;
        this.city = city;
    }

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
        Connection connection = ConnectionFactory.getConnection();
        try {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM PERSONS WHERE PERSONID=" + id);
        if (rs.next()){
            Person person = new Person();
            person.setPersonID(rs.getInt("personID"));
            person.setLastName(rs.getString("lastname"));
            person.setFirstName(rs.getString("firstname"));
            person.setAddress(rs.getString("address"));
            person.setCity(rs.getString("city"));
            System.out.println(person);
//            System.out.println("I found " + person.getFirstName() + " " + person.getLastName() + "!");
            return person;
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
