package by.epamlab.issues.service;

import by.epamlab.issues.dao.TaskDao;
import by.epamlab.issues.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;
    @Override
    public List<Task> loadTaskList() {
        return taskDao.loadTasks();
    }

    @Override
    public void addTask(Task task) {
        taskDao.addTask(task);
    }

    @Override
    public Task getLastTask() {
        return taskDao.getLastTask();
    }
}
