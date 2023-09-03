package goit.dev.hw4.repository;

import goit.dev.hw4.dao.DeveloperDao;

public class ProjectRepository {
    private ProjectDao projectDao;
    private DeveloperDao developerDao;

    public void add (ProjectDto dto) {}
    public ProjectDto get (IdDto dto) {}
    public List<ProjectDto> getAll () {}
    public ProjectWithDevelopersDto getDevelopers (ProjectDto dto) {}
    public void put (ProjectDto dto) {}
    public void remove (IdDto dto) {}
}
