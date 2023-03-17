package de.axitera.jwt.dao;


import de.axitera.jwt.model.Plane;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakePlaneDAO")
public class FakePlaneDAO implements PlaneDAO {

    private Set<Plane> planeList = new HashSet<>();

    @Override
    public boolean storePlane(UUID id, Plane plane) {
        plane.setId(id);
        return planeList.add(plane);
    }

    @Override
    public List<Plane> getPlanes() {
        return new LinkedList<>(planeList);
    }

    @Override
    public boolean deletePlaneByID(UUID id) {
       Optional<Plane> resultO = planeList.stream().filter(plane -> id.equals(plane.getId())).findFirst();

        if(resultO.isPresent())
            return planeList.remove(resultO.get());
        else
            return false;
    }

    @Override
    public boolean updatePlaneByID(UUID id,Plane plane) {
        if(!deletePlaneByID(id))
            return false;
        plane.setId(id);
        storePlane(plane);
        return true;
    }
}
