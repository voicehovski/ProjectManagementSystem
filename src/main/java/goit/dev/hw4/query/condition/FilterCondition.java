package goit.dev.hw4.query.condition;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface FilterCondition {
    void setConditionTo(PreparedStatement statement) throws SQLException;
}
