package by.epamlab.projects.service;

import by.epamlab.projects.dao.ProjectDao;
import by.epamlab.projects.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Transactional
    @Override
    public List<Project> loadProjectList() {
        return null;
    }
}
