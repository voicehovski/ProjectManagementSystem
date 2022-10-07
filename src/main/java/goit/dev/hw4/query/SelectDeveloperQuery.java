package goit.dev.hw4.query;

import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.DeveloperWithProjects;
import goit.dev.hw4.model.Project;
import goit.dev.hw4.query.condition.FilterCondition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectDeveloperQuery extends AbstractQuery<Developer> {
    public static final String QUERY = "SELECT " +
            "id, name, birth_date, birthplace, gender, salary " +
            "FROM developers";

    public SelectDeveloperQuery() {
        this.filterCondition = statement -> {};
    }

    @Override
    public String getQuery() {
        return QUERY;
    }

    @Override
    public List<Developer> createEntity(ResultSet rs) throws SQLException {
        List<Developer> developerList = new ArrayList<>();
        while (rs.next()){
            developerList.add(Developer.createFromResultSet(rs));
        }
        return developerList;
    }
}
