package goit.dev.hw4.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Developer implements Entity {
    private Id id;
    private String name;
    private Date birthDate;
    private String birthPlace;
    private String gender;
    private int salary;

    public static Developer createFromResultSet (ResultSet rs) throws SQLException {
        return new Developer(
                new Id(rs.getLong("id")),
                rs.getString("name"),
                rs.getDate("birth_date"),
                rs.getString("birthplace"),
                rs.getString("gender"),
                rs.getInt("salary")
        );
    }

    public Developer(Id id, String name, Date birthDate, String birthPlace, String gender, int salary) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.gender = gender;
        this.salary = salary;
    }

    @Override
    public void setId (Id id){
        this .id = id;
    }

    @Override
    public Id getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getGender() {
        return gender;
    }

    public int getSalary() {
        return salary;
    }
}
