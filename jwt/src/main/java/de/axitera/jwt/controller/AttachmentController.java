package de.axitera.jwt.controller;

import de.axitera.jwt.model.Attachment;
import de.axitera.jwt.service.AttachmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/attachment")
public class AttachmentController {
    private AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping("/{id}")
    public void addAttachment(@RequestBody Attachment attachment){
        attachmentService.addAttachment(attachment);
    }

    @GetMapping()
    public List<Attachment> getAttachments(){
        return attachmentService.getAllAttachments();
    }

    @GetMapping("/{id}")
    public Attachment getAttachmentsForId(@PathVariable UUID id){
        return attachmentService.getAttachmentForID(id);
    }

    @DeleteMapping("/{id}")
    public void removeAttachment(@PathVariable UUID id){
        attachmentService.removeAttachment(id);
    }

    @PutMapping("/{id}")
    public void updateAttachment(@PathVariable UUID id, @RequestBody Attachment attachment){
        attachmentService.updateAttachment(id, attachment);
    }

}
