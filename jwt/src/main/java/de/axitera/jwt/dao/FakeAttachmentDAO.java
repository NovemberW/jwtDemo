package de.axitera.jwt.dao;


import de.axitera.jwt.model.Attachment;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeAttachmentDAO")
public class FakeAttachmentDAO implements AttachmentDAO{

    private Set<Attachment> attachments = new HashSet<>();
    @Override
    public boolean storeAttachment(UUID id, Attachment att) {
        att.setId(id);
        return attachments.add(att);
    }

    @Override
    public List<Attachment> getAttachments() {
        return List.copyOf(attachments);
    }


    @Override
    public boolean deleteAttachmentForId(UUID id) {
        Optional<Attachment> resultO = attachments.stream().filter(attachment -> id.equals(attachment.getId())).findFirst();

        if(resultO.isPresent())
            return attachments.remove(resultO.get());

        return false;
    }

    @Override
    public boolean updateAttachmentForId(UUID id, Attachment att) {
        if(!deleteAttachmentForId(id))
            return false;
        att.setId(id);
        storeAttachment(att);
        return true;
    }
}
