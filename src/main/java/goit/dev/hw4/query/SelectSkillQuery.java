package goit.dev.hw4.query;

import goit.dev.hw4.model.Skill;
import goit.dev.hw4.query.common.AbstractSelectQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectSkillQuery extends AbstractSelectQuery {
    public SelectSkillQuery() {
        super(statement -> {});
    }

    @Override
    public String getQuery() {
        return "SELECT " +
                "id, trend, level " +
                "FROM skills";
    }
}
