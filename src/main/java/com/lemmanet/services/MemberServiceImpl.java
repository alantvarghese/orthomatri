package com.lemmanet.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lemmanet.domain.Member;
import com.lemmanet.domain.MemberEducation;
import com.lemmanet.domain.MemberReference;
import com.lemmanet.repositories.MemberEducationeRepository;
import com.lemmanet.repositories.MemberReferenceRepository;
import com.lemmanet.repositories.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;
    private MemberReferenceRepository memberReferenceRepository ;
    private MemberEducationeRepository memberEducationRepository ;

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Autowired
    public void setMemberReferenceeRepository(MemberReferenceRepository memberReferenceRepository) {
        this.memberReferenceRepository = memberReferenceRepository;
    }
    @Autowired
    public void setMemberEducationeRepository(MemberEducationeRepository memberEducationRepository) {
        this.memberEducationRepository = memberEducationRepository;
    }

    @Override
    public Iterable<Member> listAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(Integer id) {
    	
        Member member = memberRepository.findById(id).orElse(null);
        if(member!=null) {
    		List<MemberReference> memberReference = memberReferenceRepository.findByMember(member, Sort.unsorted());
			if (memberReference==null) { memberReference = new ArrayList<MemberReference>();}
			member.setMemberReference(memberReference);
    		List<MemberEducation> memberEducation = memberEducationRepository.findByMember(member, Sort.unsorted());
			if (memberEducation==null) { memberEducation = new ArrayList<MemberEducation>();}
    		member.setMemberEducation(memberEducation);
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
        for (MemberEducation mEd : member.getMemberEducation()) {
        	mEd.setMember(m);
        	memberEducationRepository.save(mEd);
		}
        

//        memberReferenceRepository.saveAll(member.getMemberReference());
        return m;
	
    }
}
