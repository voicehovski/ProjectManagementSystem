package goit.dev.hw4.model.builder;

import goit.dev.hw4.model.Developer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeveloperBuilder implements EntityBuilder<Developer> {
    @Override
    public List<Developer> createEntity(ResultSet rs) throws SQLException {
        List<Developer> developerList = new ArrayList<>();
        while (rs.next()){
            developerList.add(Developer.createFromResultSet(rs));
        }
        return developerList;
    }
}
