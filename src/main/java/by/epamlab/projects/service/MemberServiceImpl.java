package by.epamlab.projects.service;

import by.epamlab.projects.dao.MemberDao;
import by.epamlab.projects.model.Member;
import by.epamlab.projects.model.Project;
import by.epamlab.users.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Override
    public List<Project> loadProjectMemberList(Employee user) {
        /* load projects in which user is teamlead or manager
        * and which are not completed*/
        List<Member> members = memberDao.getMembers();
        List<Project> projects = new ArrayList<Project>();
        for (Member member: members) {
            if (member.getEmployee().getId() == user.getId()) {
                if ("Team Leader".equals(member.getRole().getName()) || "Project Manager".equals(member.getRole().getName())) {
                    projects.add(member.getProject());
                }
            }
        }
        return projects;
    }

    @Override
    public Member getMemberById(int memberId) {
        return memberDao.getMemberById(memberId);
    }
}
