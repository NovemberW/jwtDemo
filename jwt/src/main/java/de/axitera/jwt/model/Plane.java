package de.axitera.jwt.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plane {
    private UUID id;
//    @NotBlank Dependency missing - fix later -> @Valid in methods also
    private String name;
    private double scale;

    public Plane(@JsonProperty("name") String name,@JsonProperty("scale") double scale) {
        id = UUID.randomUUID();
        this.name = name;
        this.scale = scale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plane plane = (Plane) o;

        return id != null ? id.equals(plane.id) : plane.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scale=" + scale +
                '}';
    }
}
