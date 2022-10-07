package goit.dev.hw4.model;

import java.util.ArrayList;
import java.util.List;

public class DeveloperWithSkills {
    private Developer developer;
    private List<Skill> skills;

    public DeveloperWithSkills(Developer developer, List<Skill> skills) {
        this.developer = developer;
        this.skills = skills;
    }

    public DeveloperWithSkills(Developer developer) {
        this.developer = developer;
        this.skills = new ArrayList<>();
    }

    public Developer getDeveloper() {
        return developer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void addSkill (Skill skill) {
        skills.add(skill);
    }
}
