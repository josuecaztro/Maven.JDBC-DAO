package daos;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.ArrayList;
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

    private Person extractResults(ResultSet rs) throws SQLException {
        Person person = new Person();
        person.setPersonID(rs.getInt("personID"));
        person.setLastName(rs.getString("lastname"));
        person.setFirstName(rs.getString("firstname"));
        person.setAddress(rs.getString("address"));
        person.setCity(rs.getString("city"));
        System.out.println("Found " + person.getFirstName() + " " + person.getLastName());
        return person;
    }


    @Override
    public Object findById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM PERSONS WHERE PERSONID=" + id);
        if (rs.next()){
            return extractResults(rs);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List findAll() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rss = stmt.executeQuery("SELECT * FROM PERSONS");
            List<Person> allPeople = new ArrayList();
            while (rss.next()){
                Person aPerson = extractResults(rss);
                allPeople.add(aPerson);
            }
            return allPeople;
        } catch (SQLException e){
            e.printStackTrace();;
        }
        return List.of();
    }

    @Override
    public Object update(Object dto) {
        return null;
    }

    @Override
    public Object create(Person dto) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO PERSONS VALUES (?,?,?,?,?);");
            ps.setInt(1, dto.getPersonID());
            ps.setString(2, dto.getLastName());
            ps.setString(3, dto.getFirstName());
            ps.setString(4, dto.getAddress());
            ps.setString(5, dto.getCity());
            ps.executeUpdate();
            System.out.println("New person created to table.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try{
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DELETE FROM PERSONS WHERE PERSONID=" + id);
            System.out.println("Person deleted from records.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
