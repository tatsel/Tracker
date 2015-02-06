package by.epamlab.projects.dao;

import by.epamlab.projects.model.Member;

import java.util.List;

public interface MemberDao {
    List<Member> getMembers();
    //Member getMember(String memberName);
    void deleteMember(Integer id);
    void addMember(Member member);
}
