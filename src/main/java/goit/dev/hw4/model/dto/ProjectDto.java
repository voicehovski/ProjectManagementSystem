package goit.dev.hw4.model.dto;

import java.sql.Date;

public class ProjectDto {
    private long id;
    private String name ;
    private Date start ;
    private long companyId;
    private long customerId;
    private int cost;

    public ProjectDto(long id, String name, Date start, long companyId, long customerId, int cost) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.companyId = companyId;
        this.customerId = customerId;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getStart() {
        return start;
    }

    public long getCompanyId() {
        return companyId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public int getCost() {
        return cost;
    }
}
