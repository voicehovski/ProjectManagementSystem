package goit.dev.hw4;



import goit.dev.hw4.api.controller.*;
import goit.dev.hw4.api.mapper.*;
import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.config.PropertiesConfig;
import goit.dev.hw4.model.*;
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

        Mapper<NumberDto, Integer> agregateNumberMapper = new NumberMapper();
        Mapper<DeveloperDto, Developer> developerMapper = new DeveloperMapper();
        Mapper<ProjectDto, Project> projectMapper = new ProjectMapper();
        Mapper<DeveloperWithProjectsDto, DeveloperWithProjects> developerWithProjectsMapper = new DeveloperWithProjectsMapper(developerMapper, projectMapper);
        Mapper<ProjectWithDevelopersDto, ProjectWithDevelopers> projectWithDevelopersMapper = new ProjectWithDevelopersMapper(developerMapper, projectMapper);
        Mapper<SkillDto, Skill> skillMapper = new SkillMapper();

        AgregateService agregateNumberService = new DefaultAgregateService(manager);
        SelectService selectService = new SelectEntityService(manager);
        UpdateService updateService = new UpdateEntityService(manager);
        InsertService insertService = new InsertEntityService(manager);
        DeleteService deleteService = new DeleteEntityService(manager);

        // Init UI
        View view = new DefaultView();
        HelpCommand helpCommand = new HelpCommand(view);
        Command[] commands = {
                helpCommand,
                new ExitCommand(),
                new GetTotalSalaryByProjectCommand(
                        new AgregateTotalSalaryByProjectController(agregateNumberService, agregateNumberMapper),
                        view
                ),
                new GetDevelopersBySkillTrendCommand(
                        new SelectDevelopersBySkillTrendContorller(selectService, developerMapper),
                        view
                ),
                new GetDevelopersBySkillLevelCommand(
                        new SelectDevelopersBySkillLevelContorller(selectService, developerMapper),
                        view
                ),
                new GetAllDevelopersCommand(
                        new SelectDeveloperController(selectService, developerMapper),
                        view
                ),
                new CreateDeveloperCommand(
                        new InsertDeveloperController(insertService),
                        view
                ),
                new EditDeveloperCommand(
                        new UpdateDeveloperController(updateService),
                        view
                ),
                new RemoveDeveloperCommand(
                        new DeleteDeveloperController(deleteService),
                        view
                ),
                new GetFormattedProjectWithDevelopersCommand(
                        new SelectProjectWithDevelopersController(selectService, projectWithDevelopersMapper),
                        view
                ),
                new GetDeveloperByProjectCommand(
                        new SelectDeveloperByProjectController(selectService, developerMapper),
                        view
                ),
                new GetAllSkillsCommand(
                        new SelectSkillController(selectService, skillMapper),
                        view
                ),
                new EditSkillCommand(
                        new UpdateSkillController(updateService),
                        new SelectSkillController(selectService, skillMapper),
                        view
                ),
                new RemoveSkillCommand(
                        new DeleteSkillController(deleteService),
                        view
                ),
                new CreateSkillCommand(
                        new InsertSkillController(insertService),
                        new SelectSkillController(selectService, skillMapper),
                        view
                ),
                new GetAllProjectsCommand(
                        new SelectProjectController(selectService, projectMapper),
                        view
                ),
                new GetProjectsByNameCommand(
                        new SelectProjectByNameController(selectService,projectMapper),
                        view
                ),
                new CreateProjectCommand(
                        new InsertProjectController(insertService),
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