package de.axitera.jwt.controller;


import de.axitera.jwt.model.Plane;
import de.axitera.jwt.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/plane")
public class PlaneController {
    private final PlaneService planeService;

    @Autowired
    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    @PostMapping()
    public void addPlane(@RequestBody Plane plane){
        planeService.addPlane(plane);
    }

    @GetMapping()
    public List<Plane> getPlane(){
        return planeService.getAllPlanes();
    }

    @DeleteMapping("/{id}")
    public void removePlane(@PathVariable UUID id){
        planeService.removePlane(id);
    }

    @PutMapping("/{id}")
    public void updatePlane(@PathVariable UUID id,@RequestBody Plane plane){
        System.out.println(plane);
        planeService.updatePlane(id, plane);
    }
}
