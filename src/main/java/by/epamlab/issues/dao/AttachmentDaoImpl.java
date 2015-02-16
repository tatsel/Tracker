package by.epamlab.issues.dao;

import by.epamlab.issues.model.Attachment;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Blob;
import java.util.List;
@Repository
public class AttachmentDaoImpl implements AttachmentDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(Attachment attachment) {
        sessionFactory.getCurrentSession().saveOrUpdate(attachment);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Attachment> getAttachments() {
        List<Attachment> attachments = sessionFactory.getCurrentSession()
                .createQuery("from Attachment ")
                .list();
        return attachments;
    }

    @Override
    public Attachment getById(Integer id) {
       return (Attachment)sessionFactory.getCurrentSession().get(Attachment.class, id);

    }

    @Override
    public void delete(Integer id) {
        Attachment attachment = getById(id);
        sessionFactory.getCurrentSession().delete(attachment);
    }

    @Override
    public Blob getBlob(byte[] bytes) {
        return Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(bytes);
    }
}
