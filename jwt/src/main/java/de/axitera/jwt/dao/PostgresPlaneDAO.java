package de.axitera.jwt.dao;


import de.axitera.jwt.model.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("postgresPlaneDAO")
public class PostgresPlaneDAO implements PlaneDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresPlaneDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean storePlane(UUID id, Plane plane) {
        plane.setId(id);
        String insert= "INSERT INTO plane (id, name, scale) VALUES ('" + id + "','" + plane.getName() + "'," + plane.getScale() + ");";
        return jdbcTemplate.update(insert) == 1;
    }

    @Override
    public List<Plane> getPlanes() {
        String getAllPlanes = "SELECT * FROM plane;";
        return jdbcTemplate.query(getAllPlanes, (rs,i) -> {
            UUID id = UUID.fromString(rs.getString("id"));
            String name = rs.getString("name");
            double scale = rs.getDouble("scale");
            return new Plane(id,name,scale);
        });

    }

    @Override
    public boolean deletePlaneByID(UUID id) {
       String delete = "DELETE FROM plane WHERE id ='" + id + "';";
       return jdbcTemplate.update(delete) == 1;

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
