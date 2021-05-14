package com.lemmanet.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.lemmanet.domain.Member;
import com.lemmanet.domain.MemberReference;

public interface MemberReferenceRepository extends CrudRepository<MemberReference, Integer> {
	
	 List<MemberReference> findByMember(Member member, Sort sort);
	
	 List<MemberReference> findByMemberId(Integer memberId);
	 Optional<MemberReference> findByidreferenceAndMemberId(Integer id, Integer memberId);
}
