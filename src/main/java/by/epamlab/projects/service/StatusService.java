package by.epamlab.projects.service;

import by.epamlab.projects.model.Status;

import java.util.List;

public interface StatusService {
    public List<Status> loadStatusList();

    Status getStatusByName(String status);
}
