package by.epamlab.issues.service;

import by.epamlab.issues.model.Activity;

import java.util.List;

public interface ActivityService {
    List<Activity> loadActivities();

    void addActivity(Activity activity);
}
