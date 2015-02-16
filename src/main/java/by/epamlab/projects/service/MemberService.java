package by.epamlab.projects.service;

import by.epamlab.projects.model.Member;
import by.epamlab.projects.model.Project;
import by.epamlab.users.model.Employee;

import java.util.List;

public interface MemberService {
    public List<Member> loadMemberList();

    public void addMember(Member member);

    void deleteMember(Integer id);

    List<Project> loadProjectMemberList(Employee user);

    Member getMemberById(int memberId);
}
