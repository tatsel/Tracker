package by.epamlab.issues.service;

import by.epamlab.issues.model.Attachment;

import java.sql.Blob;
import java.util.List;

public interface AttachmentService {

    void save(Attachment attachment);

    List<Attachment> getAttachments();

    Attachment getById(Integer id);

    void delete(Integer id);

    Blob getBlob(byte[] bytes);
}
