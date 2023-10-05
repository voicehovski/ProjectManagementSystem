package goit.dev.hw4.repository;

import goit.dev.hw4.api.mapper.DeveloperMapper;
import goit.dev.hw4.dao.DeveloperDao;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.IdDto;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DeveloperRepository {
    private DeveloperDao developerDao;

    public Id add (Developer entity) {
        return developerDao .insert(entity);
    }
    public Optional<Developer> get (Id id) {
        return developerDao .select (id);
    }
    public List<Developer> getAll () {
        return developerDao .selectAll();
    }
    public int put (Developer entity) {
        return developerDao .update(entity);
    }
    public int remove (int id) {
        return developerDao .delete(id);
    }
}
