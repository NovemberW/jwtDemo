package de.axitera.jwt.service;


import de.axitera.jwt.dao.AttachmentDAO;
import de.axitera.jwt.model.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AttachmentService {

    @Autowired
    private AttachmentDAO attachmentDAO;

    public AttachmentService(AttachmentDAO attachmentDAO) {
        this.attachmentDAO = attachmentDAO;
    }

    public boolean addAttachment(Attachment att){
        return attachmentDAO.storeAttachment(att);
    }

    public List<Attachment> getAllAttachments(){
        return attachmentDAO.getAttachments();
    }

    public Attachment getAttachmentForID(UUID id){
        Optional<Attachment> result = attachmentDAO.getAttachments().stream().filter(att -> att.getId().equals(id)).findFirst();
        if(result.isPresent())
            return result.get();
        return null;
    }

    public boolean removeAttachment(UUID id) {
        return attachmentDAO.deleteAttachmentForId(id);
    }

    public boolean updateAttachment(UUID id, Attachment att) {
        return attachmentDAO.updateAttachmentForId(id,att);
    }
}
