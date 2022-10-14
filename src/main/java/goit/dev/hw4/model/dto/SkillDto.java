package goit.dev.hw4.model.dto;

public class SkillDto {
    private long id;
    private String trend;
    private String level;

    public SkillDto(long id, String trend, String level) {
        this.id = id;
        this.trend = trend;
        this.level = level;
    }

    public SkillDto(String trend, String level) {
        this.trend = trend;
        this.level = level;
    }

    public long getId() {
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
        return String.format("[%d] %s %s", id, level, trend);
    }
}
