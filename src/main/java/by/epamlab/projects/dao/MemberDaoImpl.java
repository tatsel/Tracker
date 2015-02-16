package by.epamlab.projects.dao;

import by.epamlab.projects.model.Member;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MemberDaoImpl implements MemberDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Member> getMembers() {
        List<Member> members;
        members = sessionFactory.getCurrentSession()
                .createQuery("from Member")
                .list();
        return members;
    }

   /* @Override
    public Member getMember(String memberName) {
        Member member = (Member)sessionFactory.getCurrentSession()
                .createQuery("from Member where name =:name")
                .setString("name", memberName)
                .uniqueResult();
        return member;
    }*/

    @Override
    public void deleteMember(Integer id) {
        sessionFactory.getCurrentSession()
                .createQuery("delete from Member where id= :id")
                .setString("id", Integer.toString(id)).executeUpdate();
    }

    @Override
    public void addMember(Member member) {
        sessionFactory.getCurrentSession().save(member);
    }

    @Override
    public Member getMemberById(int memberId) {
        Member member = (Member)sessionFactory.getCurrentSession()
                .createQuery("from Member where id =:id")
                .setString("id", String.valueOf(memberId))
                .uniqueResult();
        return member;
    }
}
