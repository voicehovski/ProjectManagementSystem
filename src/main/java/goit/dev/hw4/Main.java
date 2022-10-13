package goit.dev.hw4;



import goit.dev.hw4.api.controller.*;
import goit.dev.hw4.api.controller.common.AgregateController;
import goit.dev.hw4.api.controller.common.SelectController;
import goit.dev.hw4.api.mapper.*;
import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.config.PropertiesConfig;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.DeveloperWithProjects;
import goit.dev.hw4.model.dto.*;
import goit.dev.hw4.service.*;

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

        SelectService<Developer> selectDeveloperService = new SelectEntityService(manager);
        SelectService<DeveloperWithProjects> selectDevelopersWithProjectsService
                = new SelectEntityService(manager);
        AgregateService<Integer> totalSallrayService = new TotalSalaryService(manager);

        // Delete developer
        //new DeleteDeveloperController(manager).delete(new IdDto(5));

        // Insert new developer
        //new InsertDeveloperController(manager).insert(
        //    new DeveloperDto(0, "Sam", Date.valueOf("1992-01-01"), "Shire", "male", 3000)
        //);

        // Update developer
        new UpdateDeveloperController(manager).update(
                new DeveloperDto(1L, "Agronom", Date.valueOf("1991-08-24"), "Kyiv", "male", 4000));

        //Select different developer sets
        SelectController<DeveloperDto, Developer> selectDeveloperController
                = new SelectController<>(selectDeveloperService, developerMapper);
        List<DeveloperDto> allDevelopers
                = new SelectAllDevelopersController(selectDeveloperController).select();
        List<DeveloperDto> javaDevelopers
                = new SelectDevelopersBySkillTrendContorller(selectDeveloperController)
                .select(new FilterByStringDto("java"));
        List<DeveloperDto> middleDevelopers
                = new SelectDevelopersBySkillLevelContorller(selectDeveloperController)
                .select(new FilterByStringDto("middle"));


        // Select all developer with projects set
        SelectController <DeveloperWithProjectsDto, DeveloperWithProjects> selectDeveloperWithProjectsController
                = new SelectController<>(selectDevelopersWithProjectsService, developerWithProjectsMapper);
        List<DeveloperWithProjectsDto> allDevelopersWithProjects
                = new SelectDeveloperWithProjectsController(selectDeveloperWithProjectsController)
                .select();

        // Select total salary in particular project
        AgregateController<NumberDto, Integer> agregateTotalSalaryByProjectController
                = new AgregateController<>(totalSallrayService,new NumberMapper());
        NumberDto totalSallary
                = new AgregateTotalSalaryByProjectController(agregateTotalSalaryByProjectController)
                .select(new IdDto(1L));
    }
}