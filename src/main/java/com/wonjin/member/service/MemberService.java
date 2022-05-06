package com.wonjin.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wonjin.member.dao.MemberDao;
import com.wonjin.memberVo.Member;


@Service
public class MemberService {

	@Autowired
	private MemberDao dao;

	public Member getOneMember(Member m) {
		
		return dao.getOneMember(m);
	}

	public int signUpMember(Member m) {
		
		return dao.signUpMember(m);
	}

	public int updateMember(Member m) {
		// TODO Auto-generated method stub
		return dao.updateMember(m);
	}

	public int deleteMember(Member m) {
		
		return dao.deleteMember(m);
	}
}
