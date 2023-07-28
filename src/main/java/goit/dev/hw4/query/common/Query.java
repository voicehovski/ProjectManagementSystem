package goit.dev.hw4.query.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Query<R> {  // todo Разные типы Query для разных запросов List<R>, R, void...
    PreparedStatement createStatement(Connection connection) throws SQLException;
    List<R> createEntity(ResultSet rs) throws SQLException;
    String getQuery();
}
