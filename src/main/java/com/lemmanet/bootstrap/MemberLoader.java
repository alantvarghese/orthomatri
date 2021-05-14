package com.lemmanet.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.lemmanet.domain.Member;
import com.lemmanet.repositories.MemberReferenceRepository;
import com.lemmanet.repositories.MemberRepository;

import java.math.BigDecimal;

@Component
public class MemberLoader implements ApplicationListener<ContextRefreshedEvent> {

    private MemberRepository memberRepository;
    private MemberReferenceRepository memberReferenceRepository;
    

    private Logger log = LogManager.getLogger(MemberLoader.class);

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Autowired
    public void setMemberReferenceRepository(MemberReferenceRepository memberReferenceRepository) {
        this.memberReferenceRepository = memberReferenceRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

//        Member ammu = new Member();
//        ammu.setAddress("Piravom, Kerala, India");
//        ammu.setEducation("B Com");
//        ammu.setProfession("MBA Student");
//        ammu.setFirstName("Sona");
//        ammu.setLastName("Babu");
//        ammu.setReligion("Orthodox Christian");
//        ammu.setNickName("Ammu");
//        
//        
//        ammu.setDescription("Parents are Babu Jacob Medamana (Malayala Manorama) and Anie C Paul (State Govt.)");
//        ammu.setAge(Integer .valueOf(23));
//        ammu.setImageUrl("https://drive.google.com/thumbnail?id=1DF-3HjNbH0xjEk0IRFf0q1T8SaDQGtUR");
//        ammu.setMemberId("235268845711068308");
//        memberRepository.save(ammu);
//
//        log.info("Saved Shirt - id: " + ammu.getId());
//
//        Member njGuy = new Member();
//        njGuy.setDescription("New Jersey Guy");
//        njGuy.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
//        njGuy.setMemberId("168639393495335947");
//        njGuy.setAge(Integer .valueOf(28));
//        memberRepository.save(njGuy);
//
//        log.info("Saved Mug - id:" + njGuy.getId());
    }
}
