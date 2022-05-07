package com.wonjin.member.Controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.annotation.SessionScope;

import com.wonjin.member.service.MemberService;
import com.wonjin.memberVo.Member;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;

	@RequestMapping(value = "loginForm.com")
	public String loginForm(Member m, HttpSession session, Model model) {

		System.out.println(m.getMemberId());
		System.out.println(m.getMemberPw());
		Member member = service.getOneMember(m);

		if (member != null) {
			session.setAttribute("m", member);
		}
		System.out.println(m.getMemberName());
		return "redirect:/";

	}

	@RequestMapping(value = "logoutForm.com")
	public String logoutForm(HttpSession session) {
		session.invalidate();
		return "redirect:/";

	}

	@RequestMapping(value = "signUpFrm.com")
	public String signUpFrm() {

		return "member/signUp";
	}

	@RequestMapping(value = "signUp.com")
	public String signUp(Member m) {

		int result = service.signUpMember(m);
		if (result > 0) {
			return "redirect:/";
		} else {
			return "member/signUp";
		}

	}

	@RequestMapping(value = "mypageFrm.com")
	public String mypageFrm() {

		return "member/mypage";
	}
	@RequestMapping(value="updateMember.com")
	public String updateMember(Member m,HttpSession session) {
		int result = service.updateMember(m);
		if (result >0 ){
			session.setAttribute("m", m);
			return "member/mypage";
		}else {
			
			return "member/failUpdate";
		}
	}
	@RequestMapping(value="deleteMember.com")
	public String deleteMember(@SessionAttribute(required=false) Member m) {
		
		int result = service.deleteMember(m);
		if(result>0) {
			return "redirect:logoutForm.com";
		}else {
			return "member/mypage";
		}
		
	}
	
	@RequestMapping(value="searchOneId.com")
	public String searchOneId(Member m, Model model) {
		Member member =service.searchOneMember(m);
		if(member!=null) {
		model.addAttribute("m",member);
		return"member/searchOneMember";
		}else {
			return "redirect:/";
		}
		
	}
	@RequestMapping(value="searchMemberId.com")
	public String searchMemberId(String keyword, Model model) {
		System.out.println(keyword);
		ArrayList<Member> list = service.searchMemberId(keyword);
		
		if(list!=null) {
			model.addAttribute("list", list);
			return "member/searchMemberId";	
		}else {
			return "redirect:/";
		}
		
	}
	@RequestMapping(value="idOrName.com")
	public String idOrName(Member m, Model model) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("memberId", m.getMemberId());
		map.put("memberName",m.getMemberName());
		
		ArrayList<Member> list= service.getIdorName(map);
		model.addAttribute("list",list);
		
		return "member/IdOrName";
	}
	@RequestMapping(value="select.com")
	public String select(String option) {
		System.out.println(option);
		return "redirect:/";
		
	}
	@RequestMapping(value="searchMember3Frm.com")
	public String searchMemberFrm(Model model) {
		ArrayList<Member> list = service.searchMember();
		model.addAttribute("list",list);
	return "member/searchMember";
	}
	@RequestMapping(value="searchMembers.com")
	public String searchMembers(String[] memberId,Model model) {
		
		ArrayList<Member> list = service.getMemberList(memberId);
		model.addAttribute("list",list);
		return "member/searchMembers";
	}
	
}
