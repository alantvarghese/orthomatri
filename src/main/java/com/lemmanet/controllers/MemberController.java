package com.lemmanet.controllers;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lemmanet.domain.Member;
import com.lemmanet.domain.MemberReference;
import com.lemmanet.services.MemberService;


@Controller
public class MemberController {

    private MemberService memberService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("members", memberService.listAllMembers());
        System.out.println("Returning rpoducts:");
        return "members";
    }

    @RequestMapping("member/{id}")
    public String showMember(@PathVariable Integer id, Model model){
        model.addAttribute("member", memberService.getMemberById(id));
        return "membershow";
    }

    @RequestMapping("member/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("member", memberService.getMemberById(id));
        return "memberform";
    }

    @RequestMapping("member/new")
    public String newMember(Model model){
        model.addAttribute("member", new Member());
        return "memberform";
    }

    @RequestMapping(value = "member", method = RequestMethod.POST)
    public String saveMember(Member member){

        memberService.saveMember(member);

        return "redirect:/member/" + member.getId();
    }

    
    @RequestMapping(value="{tab}",method = RequestMethod.GET)
    public String tab(@PathVariable String tab) {
        if (Arrays.asList("tab1", "tab2", "tab3")
                  .contains(tab)) {
            return "_" + tab;
        }

        return "empty";
    }
    
    @RequestMapping(value = "member", method = RequestMethod.POST, params={"addRow"})
    public String addRow(Member member){
    	member.getMemberReference().add(new MemberReference());
    	return "memberform";
    }
    @RequestMapping(value = "member", method = RequestMethod.POST, params={"removeRow"})
    public String removeRow(Member member, final BindingResult bindingResult, final HttpServletRequest req){
    	final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
    	member.getMemberReference().remove(rowId.intValue());
    	return "memberform";
    }
}
