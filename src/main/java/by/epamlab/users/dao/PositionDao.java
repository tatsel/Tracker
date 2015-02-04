package by.epamlab.users.dao;

import by.epamlab.users.model.Position;

import java.util.List;

public interface PositionDao {

    List<Position> findPositions();
    Position getPosition(String name);

}
