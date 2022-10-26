package goit.dev.hw4;



import goit.dev.hw4.api.controller.*;
import goit.dev.hw4.api.controller.common.AgregateController;
import goit.dev.hw4.api.controller.common.SelectController;
import goit.dev.hw4.api.mapper.*;
import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.config.PropertiesConfig;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.DeveloperWithProjects;
import goit.dev.hw4.model.Project;
import goit.dev.hw4.model.ProjectWithDevelopers;
import goit.dev.hw4.model.dto.*;
import goit.dev.hw4.service.*;
import goit.dev.hw4.ui.*;
import goit.dev.hw4.ui.commands.*;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String dbPassword = System.getenv("dbPassword");
        String dbUsername = System.getenv("dbUsername");
        Properties dbConnectionProperties = new PropertiesConfig().load("application.properties");
        DatabaseManagerConnector manager = new DatabaseManagerConnector(dbConnectionProperties, dbUsername, dbPassword);

        // Мапперы для общих севисов
        Mapper<DeveloperDto, Developer> developerMapper = new DeveloperMapper();
        Mapper<ProjectDto, Project> projectMapper = new ProjectMapper();
        Mapper<DeveloperWithProjectsDto, DeveloperWithProjects> developerWithProjectsMapper = new DeveloperWithProjectsMapper(developerMapper, projectMapper);
        Mapper<ProjectWithDevelopersDto, ProjectWithDevelopers> projectWithDevelopersMapper = new ProjectWithDevelopersMapper(developerMapper, projectMapper);

        // Сервисы для общих контроллеров
        SelectService<Developer> selectDeveloperService = new SelectEntityService<>(manager);
        SelectService<DeveloperWithProjects> selectDevelopersWithProjectsService
                = new SelectEntityService<>(manager);
        SelectService<ProjectWithDevelopers> selectProjectWithDevelopersService
                = new SelectEntityService<>(manager);
        AgregateService<Integer> totalSallrayService = new TotalSalaryService(manager);

        // Общие контроллеры. Содержат общую логику для select* и agregate* В принципе можно обойтись без них
        SelectController<DeveloperDto, Developer> baseSelectDeveloperController
                = new SelectController<>(selectDeveloperService, developerMapper);
        SelectController <DeveloperWithProjectsDto, DeveloperWithProjects> baseSelectDeveloperWithProjectsController
                = new SelectController<>(selectDevelopersWithProjectsService, developerWithProjectsMapper);
        SelectController <ProjectWithDevelopersDto, ProjectWithDevelopers> baseSelectProjectWithDevelopersController
                = new SelectController<>(selectProjectWithDevelopersService, projectWithDevelopersMapper);
        AgregateController<NumberDto, Integer> baseAgregateNumberController
                = new AgregateController<>(totalSallrayService,new NumberMapper());


        // Init UI
        View view = new DefaultView();
        HelpCommand helpCommand = new HelpCommand(view);
        Command[] commands = {
                helpCommand,
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
                        new SelectDeveloperController(baseSelectDeveloperController),
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
                ),
                new GetDeveloperByProjectCommand(
                        new SelectDeveloperByProjectController(baseSelectDeveloperController),
                        view
                ),
                new GetAllSkillsCommand(
                        new SelectSkillController(manager),
                        view
                ),
                new EditSkillCommand(
                        new UpdateSkillController(manager),
                        new SelectSkillController(manager),
                        view
                ),
                new RemoveSkillCommand(
                        new DeleteSkillController(manager),
                        view
                ),
                new CreateSkillCommand(
                        new InsertSkillController(manager),
                        new SelectSkillController(manager),
                        view
                ),
                new GetAllProjectsCommand(
                        new SelectProjectController(manager),
                        view
                ),
                new GetProjectsByNameCommand(
                        new SelectProjectByNameController(manager),
                        view
                ),
                new CreateProjectCommand(
                        new InsertProjectController(manager),
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