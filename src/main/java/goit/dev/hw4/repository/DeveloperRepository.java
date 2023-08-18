package goit.dev.hw4.repository;

import goit.dev.hw4.api.mapper.DeveloperMapper;
import goit.dev.hw4.dao.DeveloperDao;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.IdDto;

import java.util.List;

public class DeveloperRepository {
    private DeveloperDao developerDao;

    public IdDto add (Developer entity) {    // return Dto with id ?
        return developerDao .insert(new DeveloperMapper().toEntity(dto));
    }
    public DeveloperDto get (int id) {
        developerDao .select (id);
    }
    public List<DeveloperDto> getAll () {
        return developerDao .selectAll() .stream()
                .map(DeveloperMapper::toEntity);
    }
    public boolean put (Developer entity) {
        developerDao .update(new DeveloperMapper() .toEntity(dto));
    }
    public boolean remove (int id) {
        return developerDao .delete(id) != 0;
    }
}
