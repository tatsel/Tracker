package by.epamlab.projects.service;

import by.epamlab.projects.model.Member;

import java.util.List;

public interface MemberService {
    public List<Member> loadMemberList();

    public void addMember(Member member);

    void deleteMember(Integer id);
}
