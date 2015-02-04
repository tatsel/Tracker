package by.epamlab.users.dao;

import by.epamlab.users.model.Position;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PositionDaoImpl implements PositionDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @SuppressWarnings("unchecked")
    public List<Position> findPositions() {
        List<Position> positions = new ArrayList<Position>();
        positions = sessionFactory.getCurrentSession()
                .createQuery("from Position")
                .list();
        return positions;
    }

    @Override
    public Position getPosition(String name) {
        Position position;
        position = (Position) sessionFactory.getCurrentSession()
                .createQuery("from Position where name = :name")
                .setString("name", name)
                .uniqueResult();
        return position;
    }
}
