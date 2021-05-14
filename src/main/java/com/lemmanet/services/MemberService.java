package com.lemmanet.services;


import com.lemmanet.domain.Member;

public interface MemberService {
    Iterable<Member> listAllMembers();

    Member getMemberById(Integer id);

    Member saveMember(Member member);
}
