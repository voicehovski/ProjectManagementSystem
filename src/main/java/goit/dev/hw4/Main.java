package goit.dev.hw4;



import goit.dev.hw4.api.controller.*;
import goit.dev.hw4.api.mapper.*;
import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.config.PropertiesConfig;
import goit.dev.hw4.dao.DeveloperDao;
import goit.dev.hw4.dao.ProjectDao;
import goit.dev.hw4.dao.SkillDao;
import goit.dev.hw4.model.*;
import goit.dev.hw4.model.dto.*;
import goit.dev.hw4.repository.*;
import goit.dev.hw4.service.*;
import goit.dev.hw4.ui.*;
import goit.dev.hw4.ui.commands.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String dbPassword = System.getenv("dbPassword");
        String dbUsername = System.getenv("dbUsername");
        Properties dbConnectionProperties = new PropertiesConfig().load("application.properties");
        DatabaseManagerConnector manager = new DatabaseManagerConnector(dbConnectionProperties, dbUsername, dbPassword);
        Connection connection = null;
        try {
            connection = manager.createConnection();
        } catch (SQLException e) {
            // @q: What to do?
        }

        Mapper<NumberDto, Integer> agregateNumberMapper = new NumberMapper();
        Mapper<DeveloperDto, Developer> developerMapper = new DeveloperMapper();
        Mapper<ProjectDto, Project> projectMapper = new ProjectMapper();
        Mapper<DeveloperWithProjectsDto, DeveloperWithProjects> developerWithProjectsMapper = new DeveloperWithProjectsMapper(developerMapper, projectMapper);
        Mapper<ProjectWithDevelopersDto, ProjectWithDevelopers> projectWithDevelopersMapper = new ProjectWithDevelopersMapper(developerMapper, projectMapper);

        Mapper<SkillDto, Skill> skillMapper = new SkillMapper();
        Mapper<IdDto, Id> idMapper = new IdMapper();

        SkillDao skillDao = new SkillDao (connection);
        DeveloperDao developerDao = new DeveloperDao(connection);
        ProjectDao projectDao = new ProjectDao(connection);

        SkillRepository skillRepository = new SkillRepository(skillDao);
        DeveloperProjectRepository developerProjectRepository = new DeveloperProjectRepository(
                developerDao, projectDao
        );
        DeveloperRepository developerRepository = new DeveloperRepository(developerDao);
        DeveloperSkillRepository developerSkillRepository = new DeveloperSkillRepository(developerDao, skillDao);
        ProjectRepository projectRepository = new ProjectRepository(projectDao, developerDao);

        SkillService skillService = new SkillService(skillRepository);
        DeveloperProjectService developerProjectService = new DeveloperProjectService(developerProjectRepository);
        DeveloperService developerService = new DeveloperService(developerRepository);
        DeveloperSkillService developerSkillService = new DeveloperSkillService(developerSkillRepository);
        ProjectService projectService = new ProjectService(projectRepository);

        // Init UI
        View view = new DefaultView();
        HelpCommand helpCommand = new HelpCommand(view);
        Command[] commands = {
                helpCommand,
                new ExitCommand(),
                new GetTotalSalaryByProjectCommand(
                        new AgregateTotalSalaryByProjectController(developerProjectService, idMapper),
                        view
                ),
                new GetDevelopersBySkillTrendCommand(
                        new SelectDevelopersBySkillTrendContorller(developerSkillService, developerMapper),
                        view
                ),
                new GetDevelopersBySkillLevelCommand(
                        new SelectDevelopersBySkillLevelContorller(developerSkillService, developerMapper),
                        view
                ),
                new GetAllDevelopersCommand(
                        new SelectDeveloperController(developerService, developerMapper),
                        view
                ),
                new CreateDeveloperCommand(
                        new InsertDeveloperController(developerService, developerMapper, idMapper),
                        view
                ),
                new EditDeveloperCommand(
                        new UpdateDeveloperController(developerService, developerMapper),
                        view
                ),
                new RemoveDeveloperCommand(
                        new DeleteDeveloperController(developerService, idMapper),
                        view
                ),
                new GetFormattedProjectWithDevelopersCommand(
                        new SelectProjectWithDevelopersController(projectService, projectMapper),
                        view
                ),
                new GetDeveloperByProjectCommand(
                        new SelectDeveloperByProjectController(developerProjectService, developerMapper, idMapper),
                        view
                ),
                new GetAllSkillsCommand(
                        new SelectSkillController(skillService, skillMapper, idMapper),
                        view
                ),
                new EditSkillCommand(
                        new UpdateSkillController(skillService, skillMapper),
                        new SelectSkillController(skillService, skillMapper, idMapper),
                        view
                ),
                new RemoveSkillCommand(
                        new DeleteSkillController(skillService),
                        view
                ),
                new CreateSkillCommand(
                        new InsertSkillController(skillService, skillMapper, idMapper),
                        new SelectSkillController(skillService, skillMapper, idMapper),
                        view
                ),
                new GetAllProjectsCommand(
                        new SelectProjectController(projectService, projectMapper, idMapper),
                        view
                ),
                new GetProjectsByNameCommand(
                        new SelectProjectByNameController(projectService, projectMapper),
                        view
                ),
                new CreateProjectCommand(
                        new InsertProjectController(projectService, projectMapper),
                        view
                )
        };
        helpCommand.setCommands(commands);

        // Start UI loop
        while (true) {
            System.out.println("\nEnter a command. Type 'help' if in doubt.");
            String input = view .read();
            for (Command command : commands) {
                if (command.canExecute(input)){
                    try {
                        command.execute();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Something went wrong. Try again.");
                    }
                }
            }
        }
    }
}