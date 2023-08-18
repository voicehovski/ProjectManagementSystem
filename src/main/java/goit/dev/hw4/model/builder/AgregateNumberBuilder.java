package goit.dev.hw4.model.builder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class AgregateNumberBuilder implements EntityBuilder<Integer> {
    @Override
    public List<Integer> createEntity(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return List.of(rs.getInt("total"));
        }
        return Collections.emptyList();
    }
}
