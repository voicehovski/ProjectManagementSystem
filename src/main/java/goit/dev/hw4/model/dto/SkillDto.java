package goit.dev.hw4.model.dto;

public class SkillDto {
    private IdDto id;
    private String trend;
    private String level;

    public SkillDto(IdDto id, String trend, String level) {
        this.id = id;
        this.trend = trend;
        this.level = level;
    }

    public SkillDto(String trend, String level) {
        this.trend = trend;
        this.level = level;
    }

    public IdDto getId() {
        return id;
    }

    public String getTrend() {
        return trend;
    }

    public String getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s %s", id.getId(), level, trend);
    }
}
