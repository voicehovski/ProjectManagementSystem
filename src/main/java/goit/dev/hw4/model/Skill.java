package goit.dev.hw4.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Skill implements Entity {
    private Id id;
    private String trend;
    private String level;

    public static Skill createFromResultSet (ResultSet rs) throws SQLException {
        return new Skill(
                new Id ( rs.getLong("id") ),
                rs.getString("trend"),
                rs.getString("level")
        );
    }

    public Skill(Id id, String trend, String level) {
        this.id = id;
        this.trend = trend;
        this.level = level;
    }

    @Override
    public void setId(Id id) {
        this .id = id;
    }

    @Override
    public Id getId() {
        return id;
    }

    public String getTrend() {
        return trend;
    }

    public String getLevel() {
        return level;
    }
}
