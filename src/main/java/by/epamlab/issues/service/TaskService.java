package by.epamlab.issues.service;

import by.epamlab.issues.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> loadTaskList();

    void addTask(Task task);

    Task getLastTask();

    Task getTaskById(Integer id);

    void deleteTask(Integer id);
}
