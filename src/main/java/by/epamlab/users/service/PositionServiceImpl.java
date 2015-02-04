package by.epamlab.users.service;

import by.epamlab.users.dao.PositionDao;
import by.epamlab.users.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PositionServiceImpl implements PositionService{
    @Autowired
    private PositionDao positionDao;

    @Transactional
    @Override
    public List<Position> loadPositions() {
        return positionDao.findPositions();
    }

    @Transactional
    @Override
    public Position getPositionByName(String name) {
        return positionDao.getPosition(name);
    }

}
