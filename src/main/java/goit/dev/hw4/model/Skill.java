package goit.dev.hw4.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Skill implements Entity {
    private long id;
    private String trend;
    private String level;

    public static Skill createFromResultSet (ResultSet rs) throws SQLException {
        return new Skill(
                rs.getLong("id"),
                rs.getString("trend"),
                rs.getString("level")
        );
    }

    public Skill(long id, String trend, String level) {
        this.id = id;
        this.trend = trend;
        this.level = level;
    }

    @Override
    public void setId(long id) {
        this .id = id;
    }

    @Override
    public long getId() {
        return id;
    }
}
