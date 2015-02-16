package by.epamlab.issues.service;

import by.epamlab.issues.dao.AttachmentDao;
import by.epamlab.issues.model.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Blob;
import java.util.List;
@Service
@Transactional
public class AttachmentServiceImpl implements AttachmentService {
    @Autowired
    AttachmentDao attachmentDao;
    @Override
    public void save(Attachment attachment) {
        attachmentDao.save(attachment);
    }

    @Override
    public List<Attachment> getAttachments() {
        return attachmentDao.getAttachments();
    }

    @Override
    public Attachment getById(Integer id) {
        return attachmentDao.getById(id);
    }

    @Override
    public void delete(Integer id) {
        attachmentDao.delete(id);
    }

    @Override
    public Blob getBlob(byte[] bytes) {
        return attachmentDao.getBlob(bytes);
    }
}
