package de.axitera.jwt.service;

import de.axitera.jwt.dao.PlaneDAO;
import de.axitera.jwt.model.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class PlaneService {
    private final PlaneDAO planeDAO;

    @Autowired
    public PlaneService(@Qualifier("postgresPlaneDAO") PlaneDAO planeDAO) {
        this.planeDAO = planeDAO;
    }

    public boolean addPlane(Plane plane){
        return planeDAO.storePlane(plane);
    }

    public List<Plane> getAllPlanes(){
        return planeDAO.getPlanes();
    }

    public boolean removePlane(UUID id) {
        return planeDAO.deletePlaneByID(id);
    }

    public boolean updatePlane(UUID id, Plane plane) {
        return planeDAO.updatePlaneByID(id, plane);
    }
}
