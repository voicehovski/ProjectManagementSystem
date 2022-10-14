package goit.dev.hw4.query;

import goit.dev.hw4.model.Developer;
import goit.dev.hw4.query.common.AbstractQuery;
import goit.dev.hw4.query.condition.FilterCondition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectDeveloperByProjectQuery extends AbstractQuery<Developer> {
    public SelectDeveloperByProjectQuery(FilterCondition filterCondition) {
        super(filterCondition);
    }

    @Override
    public String getQuery() {
        return "SELECT " +
                "developer.id, developer.name, birth_date, birthplace, gender, salary " +

                "FROM developers_to_projects AS d2p " +
                "INNER JOIN developers AS developer ON d2p.developer_id = developer.id " +
                "INNER JOIN projects AS project ON d2p.project_id = project.id " +

                "WHERE project.id = ?";
    }

    @Override
    public List<Developer> createEntity(ResultSet rs) throws SQLException {
        List<Developer> developerEntityList = new ArrayList<>();    // Задать размер?
        while (rs.next()){
            developerEntityList.add( Developer.createFromResultSet(rs) );
        }
        return developerEntityList;
    }
}
