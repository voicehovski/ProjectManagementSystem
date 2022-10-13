package goit.dev.hw4;



import goit.dev.hw4.api.controller.*;
import goit.dev.hw4.api.controller.common.AgregateController;
import goit.dev.hw4.api.controller.common.SelectController;
import goit.dev.hw4.api.mapper.*;
import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.config.PropertiesConfig;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.DeveloperWithProjects;
import goit.dev.hw4.model.ProjectWithDevelopers;
import goit.dev.hw4.model.dto.*;
import goit.dev.hw4.service.*;
import goit.dev.hw4.ui.*;

import java.sql.Date;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String dbPassword = System.getenv("dbPassword");
        String dbUsername = System.getenv("dbUsername");
        Properties dbConnectionProperties = new PropertiesConfig().load("application.properties");
        DatabaseManagerConnector manager = new DatabaseManagerConnector(dbConnectionProperties, dbUsername, dbPassword);

        DeveloperMapper developerMapper = new DeveloperMapper();    // Mapper<DeveloperDto, Developer>
        ProjectMapper projectMapper = new ProjectMapper();  // Mapper<ProjectDto, Project>
        //<DeveloperWithProjectsDto, DeveloperWithProjects>
        DeveloperWithProjectsMapper developerWithProjectsMapper = new DeveloperWithProjectsMapper(developerMapper, projectMapper);
        ProjectWithDevelopersMapper projectWithDevelopersMapper = new ProjectWithDevelopersMapper(developerMapper, projectMapper);

        SelectService<Developer> selectDeveloperService = new SelectEntityService(manager);
        SelectService<DeveloperWithProjects> selectDevelopersWithProjectsService
                = new SelectEntityService(manager);
        SelectService<ProjectWithDevelopers> selectProjectWithDevelopersService
                = new SelectEntityService(manager);
        AgregateService<Integer> totalSallrayService = new TotalSalaryService(manager);

        // Base controllers
        SelectController<DeveloperDto, Developer> baseSelectDeveloperController
                = new SelectController<>(selectDeveloperService, developerMapper);
        SelectController <DeveloperWithProjectsDto, DeveloperWithProjects> baseSelectDeveloperWithProjectsController
                = new SelectController<>(selectDevelopersWithProjectsService, developerWithProjectsMapper);
        SelectController <ProjectWithDevelopersDto, ProjectWithDevelopers> baseSelectProjectWithDevelopersController
                = new SelectController<>(selectProjectWithDevelopersService, projectWithDevelopersMapper);
        AgregateController<NumberDto, Integer> baseAgregateNumberController
                = new AgregateController<>(totalSallrayService,new NumberMapper());


        View view = new DefaultView();
        Command[] commands = {
                new HelpCommand(),
                new ExitCommand(),
                new GetTotalSalaryByProjectCommand(
                        new AgregateTotalSalaryByProjectController(baseAgregateNumberController),
                        view
                ),
                new GetDevelopersBySkillTrendCommand(
                        new SelectDevelopersBySkillTrendContorller(baseSelectDeveloperController),
                        view
                ),
                new GetDevelopersBySkillLevelCommand(
                        new SelectDevelopersBySkillLevelContorller(baseSelectDeveloperController),
                        view
                ),
                new GetAllDevelopersCommand(
                        new SelectAllDevelopersController(baseSelectDeveloperController),
                        view
                ),
                new CreateDeveloperCommand(
                        new InsertDeveloperController(manager),
                        view
                ),
                new EditDeveloperCommand(
                        new UpdateDeveloperController(manager),
                        view
                ),
                new RemoveDeveloperCommand(
                        new DeleteDeveloperController(manager),
                        view
                ),
                new GetFormattedProjectWithDevelopersCommand(
                        new SelectProjectWithDevelopersController(baseSelectProjectWithDevelopersController),
                        view
                )
        };

        while (true) {
            System.out.println("Enter a command. Type 'help' if in doubt.");
            String input = view .read();
            for (Command command : commands) {
                if (command.canExecute(input)){
                    command.execute();
                }
            }
        }
    }
}