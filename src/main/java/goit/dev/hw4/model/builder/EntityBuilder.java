package goit.dev.hw4.model.builder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface EntityBuilder<E> {
    public List<E> createEntity(ResultSet rs) throws SQLException;
}
