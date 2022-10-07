package goit.dev.hw4;



import goit.dev.hw4.api.SelectController;
import goit.dev.hw4.api.SelectDeveloperController;
import goit.dev.hw4.api.SelectDeveloperWithProjectsController;
import goit.dev.hw4.api.mapper.DeveloperMapper;
import goit.dev.hw4.api.mapper.DeveloperWithProjectsMapper;
import goit.dev.hw4.api.mapper.ProjectMapper;
import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.config.PropertiesConfig;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.DeveloperWithProjects;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.DeveloperWithProjectsDto;
import goit.dev.hw4.query.executor.SelectQueryExecutor;
import goit.dev.hw4.service.SelectDeveloperService;
import goit.dev.hw4.service.SelectDeveloperWithProjectService;
import goit.dev.hw4.service.SelectService;

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

        SelectQueryExecutor<Developer> selectDeveloperQueryExecutor = new SelectQueryExecutor<>(manager);
        SelectQueryExecutor<DeveloperWithProjects> selectDeveloperWithProjectsQueryExecutor =
                new SelectQueryExecutor<>(manager);

        SelectService<Developer> selectDeveloperService = new SelectDeveloperService(selectDeveloperQueryExecutor);
        SelectController<DeveloperDto, Developer> selectDeveloperController
                = new SelectController<>(selectDeveloperService, developerMapper);
                //= new SelectDeveloperController(selectDeveloperService, developerMapper);
        List<DeveloperDto> allDevelopers = selectDeveloperController.select();

        SelectService<DeveloperWithProjects> selectDevelopersWithProjectsService = new SelectDeveloperWithProjectService(selectDeveloperWithProjectsQueryExecutor);
        SelectController <DeveloperWithProjectsDto, DeveloperWithProjects> selectDeveloperWithProjectsController
                = new SelectController<>(selectDevelopersWithProjectsService, developerWithProjectsMapper);
                //= new SelectDeveloperWithProjectsController(selectDevelopersWithProjectsService, developerWithProjectsMapper);
        List<DeveloperWithProjectsDto> allDevelopersWithProjects =
        selectDeveloperWithProjectsController.select();
        // todo Обязательно нужно передавать сондишн, поскольку в запросе есть ?. Как сделать чтобы можно было извлечь все?

    }
}