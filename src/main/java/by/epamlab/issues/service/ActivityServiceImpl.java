package by.epamlab.issues.service;

import by.epamlab.issues.dao.ActivityDao;
import by.epamlab.issues.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ActivityDao activityDao;
    @Override
    public List<Activity> loadActivities() {
        return activityDao.loadActivities();
    }

    @Override
    public void addActivity(Activity activity) {
        activityDao.addActivity(activity);
    }
}
