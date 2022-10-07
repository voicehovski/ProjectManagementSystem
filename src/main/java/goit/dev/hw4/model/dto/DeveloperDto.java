package goit.dev.hw4.model.dto;

import java.sql.Date;

public class DeveloperDto {
    private long id;
    private String name;
    private Date birthDate;
    private String birthPlace;
    private String gender;
    private int salary;

    public DeveloperDto(long id, String name, Date birthDate, String birthPlace, String gender, int salary) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.gender = gender;
        this.salary = salary;
    }

    public long getId() {
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
