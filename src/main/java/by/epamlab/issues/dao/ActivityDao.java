package by.epamlab.issues.dao;

import by.epamlab.issues.model.Activity;

import java.util.List;

public interface ActivityDao {
    List<Activity> loadActivities();

    void addActivity(Activity activity);
}
