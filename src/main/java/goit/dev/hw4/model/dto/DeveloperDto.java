package goit.dev.hw4.model.dto;

import java.sql.Date;

public class DeveloperDto {
    private IdDto id;
    private String name;
    private Date birthDate;
    private String birthPlace;
    private String gender;
    private int salary;

    public DeveloperDto(IdDto id, String name, Date birthDate, String birthPlace, String gender, int salary) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.gender = gender;
        this.salary = salary;
    }

    public DeveloperDto(String name, Date birthDate, String birthPlace, String gender, int salary) {
        this(new IdDto(-1), name, birthDate, birthPlace, gender, salary);
    }

    public IdDto getId() {
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

    @Override
    // @q: Может сделать id.isAbsent() ?
    public String toString() {
        return String .format("[%d] %s(%s) from %s, birth %s, salary %d", id.getId() == -1 ? "": id, name, gender, birthPlace, birthDate, salary  );
    }
}
