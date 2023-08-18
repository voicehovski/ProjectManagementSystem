package goit.dev.hw4.query;

import goit.dev.hw4.model.Developer;
import goit.dev.hw4.query.common.AbstractSelectQuery;
import goit.dev.hw4.query.condition.FilterCondition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectDeveloperQuery extends AbstractSelectQuery {
    public static final String QUERY = "SELECT " +
            "id, name, birth_date, birthplace, gender, salary " +
            "FROM developers";

    public SelectDeveloperQuery() {
        super(statement -> {});
    }

    public SelectDeveloperQuery ( FilterCondition condition ) { super ( condition ); }

    @Override
    public String getQuery() {
        return QUERY;
    }
}
