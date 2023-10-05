package goit.dev.hw4.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

public class Project implements Entity {
    private Id id;
    private String name;
    private Date start; // TIMESTAMP(2),	-- Format: 2022-01-01 13:23:15.04       java.sql.Date ?
    private long company_id;
    private long customer_id;
    private int cost;

    private int developerCount;

    public Project(Id id, String name, Date start, long company_id, long customer_id, int cost) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.company_id = company_id;
        this.customer_id = customer_id;
        this .cost = cost;
    }

    public static Project createFromResultSet(ResultSet rs) throws SQLException {
        return new Project(
                new Id (rs.getLong("id")),
                rs.getString("name"),
                rs.getDate("start"),
                rs.getLong("company_id"),
                rs.getLong("customer_id"),
                rs.getInt("cost")
        );
    }

    @Override
    public void setId(Id id) {
        this.id = id;
    }

    @Override
    public Id getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getStart() {
        return start;
    }

    public long getCompanyId() {
        return company_id;
    }

    public long getCustomerId() {
        return customer_id;
    }

    public int getCost() {
        return cost;
    }

    public int getDeveloperCount() {
        return developerCount;
    }

    public void setDeveloperCount(int developerCount) {
        this.developerCount = developerCount;
    }

}
