package goit.dev.hw4.query.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Query {
    PreparedStatement createStatement(Connection connection) throws SQLException;
    String getQuery();
}
