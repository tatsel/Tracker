package by.epamlab.projects.dao;

import by.epamlab.projects.model.Status;

import java.util.List;

public interface StatusDao {
    List<Status> getStatuses();

    Status getStatus(String status);
}
