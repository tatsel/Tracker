package by.epamlab.users.service;

import by.epamlab.users.model.Position;

import java.util.List;

public interface PositionService {

    public List<Position> loadPositions();

    Position getPositionByName(String name);

}
