package goit.dev.hw4.repository;

import goit.dev.hw4.dao.DeveloperDao;
import goit.dev.hw4.dao.ProjectDao;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.Project;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class DeveloperProjectRepository {
    private DeveloperDao developerDao;
    private ProjectDao projectDao;

    public List<Developer> getByProject (Id id ) {
        Optional<Project> project = projectDao .select ( id );
    /*
        Project defaultProject = new Project(...);
        Project realProject = project .orElse(defaultProject);

        project .orElseGet(()-> {
            System.out.println("The project with such id is unreachable");
            return new Project(...);
        });
        project .orElseThrow(); // throws NoSuchElementException
    */

    //project .orElseThrow(SQLWrapperException::new)    Почему так нельзя?

        Project existedProject = project .orElseThrow(()->new NoSuchElementException("No project with id " + id));

        return developerDao .selectByProject(
                List.of(id).stream ()
                        .map(Id::getId)
                        .toArray(Id[]::new)
        );
    }

    public int getTotalSalaryByProject ( Id id ) {
        Optional<Project> project = projectDao .select ( id );
        Project existedProject = project .orElseThrow(()->new NoSuchElementException("No project with id " + id));
        //long[] a = {1L,2L};
        Optional<Integer> total = developerDao .agregateTotalSalaryByProject ( new Id [] {existedProject.getId()} );
        return total .orElseThrow(()->new RuntimeException("Can`t calculate total"));
    }
}
