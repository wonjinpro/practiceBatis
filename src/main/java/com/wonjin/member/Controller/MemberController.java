package com.wonjin.member.Controller;

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
}
