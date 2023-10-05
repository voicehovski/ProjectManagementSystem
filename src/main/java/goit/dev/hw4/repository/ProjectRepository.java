package goit.dev.hw4.repository;

import goit.dev.hw4.dao.DeveloperDao;
import goit.dev.hw4.dao.ProjectDao;
import goit.dev.hw4.exception.CalculateException;
import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.Project;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProjectRepository {
    private ProjectDao projectDao;
    private DeveloperDao developerDao;

    public ProjectRepository(ProjectDao projectDao, DeveloperDao developerDao) {
        this.projectDao = projectDao;
        this.developerDao = developerDao;
    }

    public Id add (Project entity) {
        return projectDao .insert(entity);
    }
    public Optional<Project> get (Id id) {
        return projectDao.select(id);
    }
    public List<Project> getAll () {
        return projectDao.selectAll();
    }
    public List<Project> getByName (String name) {
        return projectDao.select(name);
    }
    public int put (Project entity) {return projectDao.update(entity);}
    public int remove (Id id) {return projectDao.delete(id);}

    /*  Как правильно поступать с отношениями?
    *
    * 1) Помещать в репозиторий сущности. Это текущая реализация. В Project добавлено поле developerCount
    * 2) Сделать отдельный ProjectDeveloperRepository (поскольку здесь мы запрашиваем инфо именно о проекте)
    * 3) Свести все запросы с отношениями, независимо от результата в один репо, например DeveloperProjectRepository
    *
    * Для 2 и 3 код будет примерно таким:
    *
    * Project project = projectDao .select(id)  // Это если для одного проекта по ID
    *    .orElseThrow(()->new NoSuchElementException("No project wiht id " + id));
    * Integer developerCount = developerDao .agregateCount(project.getId())
    *    .orElseThrow(()->new RuntimeException("Can`t calculate developer count of project " + project.getId()));

    * */
    public List<Project> getWithDevelopersCount () {
        // Может нужен другой тип Entity? ProjectWithDeveloperCount ?
        return getAll() .stream().
                map(project -> {
                    Integer developerCount = developerDao .agregateCount(project.getId())
                            .orElseThrow(()->new CalculateException("Can`t calculate developer count of project " + project.getId()));
                    project .setDeveloperCount ( developerCount );
                    return project;
                })
                .collect(Collectors.toList());
    }
}
