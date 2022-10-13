package goit.dev.hw4.query;

import goit.dev.hw4.model.Developer;
import goit.dev.hw4.query.common.AbstractQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectDeveloperQuery extends AbstractQuery<Developer> {
    public static final String QUERY = "SELECT " +
            "id, name, birth_date, birthplace, gender, salary " +
            "FROM developers";

    public SelectDeveloperQuery() {
        super(statement -> {});
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
