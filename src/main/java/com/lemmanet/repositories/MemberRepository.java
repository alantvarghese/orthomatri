package com.lemmanet.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lemmanet.domain.Member;

public interface MemberRepository extends CrudRepository<Member, Integer>{
}
