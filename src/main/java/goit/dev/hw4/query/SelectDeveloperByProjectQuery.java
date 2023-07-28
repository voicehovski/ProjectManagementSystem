package goit.dev.hw4.query;

import goit.dev.hw4.query.condition.FilterCondition;

public class SelectDeveloperByProjectQuery extends SelectDeveloperQuery {
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
}
