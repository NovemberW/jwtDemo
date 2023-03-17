package de.axitera.jwt.dao;



import de.axitera.jwt.model.Attachment;

import java.util.List;
import java.util.UUID;


public interface AttachmentDAO {

    boolean storeAttachment(UUID id, Attachment att);
    default boolean storeAttachment(Attachment att){
        UUID id = (att.getId() == null || att.getId().equals("")) ? UUID.randomUUID(): att.getId();
        return storeAttachment(id, att);
    }

    List<Attachment> getAttachments();


    boolean deleteAttachmentForId(UUID id);

    boolean updateAttachmentForId(UUID id, Attachment att);


}
