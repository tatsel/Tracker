package by.epamlab.projects.service;

import by.epamlab.projects.dao.StatusDao;
import by.epamlab.projects.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StatusServiceImpl implements StatusService{

    @Autowired
    private StatusDao statusDao;

    @Override
    public List<Status> loadStatusList() {
        return statusDao.getStatuses();
    }

    @Override
    public Status getStatusByName(String status) {
        return statusDao.getStatus(status);
    }

    @Override
    public Status getStatusById(Integer statusId) {
        return statusDao.getStatusById(statusId);
    }

}
