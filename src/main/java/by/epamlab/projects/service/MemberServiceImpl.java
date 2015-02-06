package by.epamlab.projects.service;

import by.epamlab.projects.dao.MemberDao;
import by.epamlab.projects.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberDao memberDao;

    @Override
    public List<Member> loadMemberList() {
        return memberDao.getMembers();
    }

    @Override
    public void addMember(Member member) {
        memberDao.addMember(member);
    }

    @Override
    public void deleteMember(Integer id) {
        memberDao.deleteMember(id);
    }
}
