package com.wonjin.member.service;

import java.util.ArrayList;
import java.util.HashMap;

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

	public Member searchOneMember(Member m) {
		
		return dao.getOneMember(m);
	}

	public ArrayList<Member> searchMemberId(String keyword) {
		// TODO Auto-generated method stub
		return dao.searchMemberId(keyword);
	}

	public ArrayList<Member> getIdorName(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.getIdOrName(map);
	}

	public ArrayList<Member> searchMember() {
		// TODO Auto-generated method stub
		return dao.searchMember();
	}

	public ArrayList<Member> getMemberList(String[] memberId) {
		// TODO Auto-generated method stub
		return dao.getMemberList(memberId);
	}
}
