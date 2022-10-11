package goit.dev.hw4;



import goit.dev.hw4.api.AgregateController;
import goit.dev.hw4.api.SelectController;
import goit.dev.hw4.api.mapper.DeveloperMapper;
import goit.dev.hw4.api.mapper.DeveloperWithProjectsMapper;
import goit.dev.hw4.api.mapper.NumberMapper;
import goit.dev.hw4.api.mapper.ProjectMapper;
import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.config.PropertiesConfig;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.DeveloperWithProjects;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.DeveloperWithProjectsDto;
import goit.dev.hw4.model.dto.NumberDto;
import goit.dev.hw4.query.*;
import goit.dev.hw4.service.*;

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

        SelectController <DeveloperWithProjectsDto, DeveloperWithProjects> selectDeveloperWithProjectsController
                = new SelectController<>(selectDevelopersWithProjectsService, developerWithProjectsMapper);
        List<DeveloperWithProjectsDto> allDevelopersWithProjects =
        selectDeveloperWithProjectsController.select(new SelectDeveloperWithProjectsQuery());


        AgregateController<NumberDto, Integer> agregateTotalSalaryByProjectController
                = new AgregateController<NumberDto, Integer>(totalSallrayService,new NumberMapper());
        NumberDto totalSallary = agregateTotalSalaryByProjectController.select(
                new TotalSalaryQuery(statement -> statement.setLong(1,1L))    // Value from Dto
        );
    }
}