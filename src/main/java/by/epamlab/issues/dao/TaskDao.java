package by.epamlab.issues.dao;

import by.epamlab.issues.model.Task;

import java.util.List;

public interface TaskDao {
    List<Task> loadTasks();

    void addTask(Task task);

    Task getLastTask();
}
