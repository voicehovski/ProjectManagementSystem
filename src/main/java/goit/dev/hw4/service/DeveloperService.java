package goit.dev.hw4.service;

import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.Id;
import goit.dev.hw4.repository.DeveloperRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class DeveloperService {
    private DeveloperRepository repository;

    public DeveloperService(DeveloperRepository repository) {
        this.repository = repository;
    }

    public List<Developer> getAll() {
        return repository.getAll();
    }

    public Developer get(Id developerId) {
        return repository.get(developerId).orElseThrow(
                () -> new NoSuchElementException("Developer id: " + developerId.getId())
        );
    }

    public Id add(Developer developer) {
        return repository.add(developer);
    }

    public int put(Developer developer) {
        return repository.put(developer);
    }

    public int remove(Id developerId) {
        return repository.remove(developerId);
    }
}