package de.axitera.jwt.dao;



import de.axitera.jwt.model.Plane;

import java.util.List;
import java.util.UUID;

public interface PlaneDAO {
    boolean storePlane(UUID id, Plane plane);

    default boolean storePlane(Plane plane){
        UUID id = (plane.getId() == null || plane.getId().equals("")) ? UUID.randomUUID(): plane.getId();
        return storePlane(id, plane);
    }

    List<Plane> getPlanes();
    boolean deletePlaneByID(UUID id);

    boolean updatePlaneByID(UUID id, Plane plane);

}
