package de.axitera.jwt.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Attachment {
    private UUID id;
    private String type;
    private File file;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attachment that = (Attachment) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
