package goit.dev.hw4.repository;

import goit.dev.hw4.dao.DeveloperDao;
import goit.dev.hw4.dao.ProjectDao;
import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.Project;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProjectRepository {
    private ProjectDao projectDao;
    private DeveloperDao developerDao;



    public Id add (Project entity) {
        return projectDao .insert(entity);
    }
    public Optional<Project> get (Id id) {return projectDao.select(id);}
    public List<Project> getAll () {return projectDao.selectAll();}
    public int put (Project entity) {return projectDao.update(entity);}
    public int remove (Id id) {return projectDao.delete(id);}

    // Это отсюда или нужен ProjectDeveloperRepository? А может и с DeveloperRepository так же?
    public List<Project> getWithDevelopersCount () {
        //Project project = projectDao .select(id)  Это если для одного проекта по ID
        //        .orElseThrow(()->new NoSuchElementException("No project wiht id " + id));
        //Integer developerCount = developerDao .agregateCount(project.getId())
        //        .orElseThrow(()->new RuntimeException("Can`t calculate developer count of project " + project.getId()));

        // Может нужен другой тип Entity? ProjectWithDeveloperCount ?
        return getAll() .stream().
                map(project -> {
                    Integer developerCount = developerDao .agregateCount(project.getId())
                            .orElseThrow(()->new RuntimeException("Can`t calculate developer count of project " + project.getId()));
                    project .setDeveloperCount ( developerCount );
                    return project;
                })
                .collect(Collectors.toList());
    }
}
