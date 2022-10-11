package goit.dev.hw4;



import goit.dev.hw4.api.AgregateController;
import goit.dev.hw4.api.InsertController;
import goit.dev.hw4.api.SelectController;
import goit.dev.hw4.api.mapper.*;
import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.config.PropertiesConfig;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.DeveloperWithProjects;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.DeveloperWithProjectsDto;
import goit.dev.hw4.model.dto.NumberDto;
import goit.dev.hw4.query.*;
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

        SelectService<Developer> selectDeveloperService = new SelectDeveloperService(manager);
        SelectService<DeveloperWithProjects> selectDevelopersWithProjectsService
                = new SelectDeveloperWithProjectService(manager);
        AgregateService<Integer> totalSallrayService = new TotalSalaryService(manager);

        // Insert new developer
        InsertController insertDeveloperController
                = new InsertController(new InsertDeveloperService(manager));
        long createdDeveloperId = insertDeveloperController.insert(
                new InsertDeveloperQuery(statement -> {
                    statement.setString(1,"Sam");
                    statement.setDate(2, Date.valueOf("1992-01-01"));
                    statement.setString(3,"Shire");
                    statement.setString(4,"male");
                    statement.setInt(5,3000);
                })
        );

        //Select different developer sets
        SelectController<DeveloperDto, Developer> selectDeveloperController
                = new SelectController<>(selectDeveloperService, developerMapper);
                //= new SelectDeveloperController(selectDeveloperService, developerMapper);
        List<DeveloperDto> allDevelopers = selectDeveloperController.select(new SelectDeveloperQuery());
        List<DeveloperDto> javaDevelopers = selectDeveloperController.select(
                new SelectDevelopersBySkillTrendQuery(statement -> statement.setString(1, "java"))
        );
        List<DeveloperDto> middleDevelopers = selectDeveloperController.select(
                new SelectDevelopersBySkillLevelQuery(statement -> statement.setString(1, "middle"))
        );

        // Select all developer with projects set
        SelectController <DeveloperWithProjectsDto, DeveloperWithProjects> selectDeveloperWithProjectsController
                = new SelectController<>(selectDevelopersWithProjectsService, developerWithProjectsMapper);
        List<DeveloperWithProjectsDto> allDevelopersWithProjects =
        selectDeveloperWithProjectsController.select(new SelectDeveloperWithProjectsQuery());

        // Select total salary in particular project
        AgregateController<NumberDto, Integer> agregateTotalSalaryByProjectController
                = new AgregateController<>(totalSallrayService,new NumberMapper());
        NumberDto totalSallary = agregateTotalSalaryByProjectController.select(
                new TotalSalaryQuery(statement -> statement.setLong(1,1L))    // Value from Dto
        );

    }
}