package com.lemmanet.services;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lemmanet.domain.Member;
import com.lemmanet.domain.MemberReference;
import com.lemmanet.repositories.MemberReferenceRepository;
import com.lemmanet.repositories.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;
    private MemberReferenceRepository memberReferenceRepository ;

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Autowired
    public void setMemberReferenceRepository(MemberReferenceRepository memberReferenceRepository) {
        this.memberReferenceRepository = memberReferenceRepository;
    }

    @Override
    public Iterable<Member> listAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(Integer id) {
    	
        Member member = memberRepository.findById(id).orElse(null);
        if(member!=null) {
		member.setMemberReference(memberReferenceRepository.findByMember(member, Sort.unsorted()));
        }
        return member;
    }

    @Override
    public Member saveMember(Member member) {

        Member m =  memberRepository.save(member);
     	
        for (MemberReference mRef : member.getMemberReference()) {
        	mRef.setMember(m);
        	memberReferenceRepository.save(mRef);
		}
        

//        memberReferenceRepository.saveAll(member.getMemberReference());
        return m;
	
    }
}
