package by.epamlab.projects.service;

import by.epamlab.projects.model.Project;

import java.util.List;

public interface ProjectService {
    public List<Project> loadProjectList();

    public void addProject(Project project);

    void deleteProject(Integer id);

    Project getProjectById(Integer id);
}
