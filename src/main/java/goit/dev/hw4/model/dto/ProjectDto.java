package goit.dev.hw4.model.dto;

import java.sql.Date;

public class ProjectDto {
    private IdDto id;
    private String name ;
    private Date start ;
    private long companyId;
    private long customerId;
    private int cost;

    private int developerCount;

    public ProjectDto(IdDto id, String name, Date start, long companyId, long customerId, int cost) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.companyId = companyId;
        this.customerId = customerId;
        this.cost = cost;
    }

    // IdDto.createEmpty() ?
    public ProjectDto(String name, Date start, long companyId, long customerId, int cost) {
        this(new IdDto(-1), name, start, companyId, customerId, cost);
    }

    public IdDto getId() {
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

    public int getDeveloperCount () {return developerCount;}

    public void setDeveloperCount (int developerCount) {this .developerCount = developerCount;}

    @Override
    public String toString() {
        return String.format("[%1$d] %2$s starts %3$tF (cost $%4$d)", id.getId(), name, start, cost);
    }
}
