package by.epamlab.projects.dao;

import by.epamlab.projects.model.Project;

import java.util.List;

public interface ProjectDao {

    List<Project> getProjects();

    void addProject(Project project);

    void deleteProject(Integer id);

    Project getProjectById(Integer id);

}
