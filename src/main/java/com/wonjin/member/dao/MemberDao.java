package com.wonjin.member.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wonjin.memberVo.Member;

@Repository
public class MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public Member getOneMember(Member m) {
		
		Member member = sqlSession.selectOne("member.selectOneMember",m);
		return member;
	}

	public int signUpMember(Member m) {
		
		int result = sqlSession.insert("member.signUpMember",m);
		return result;
	}

	public int updateMember(Member m) {
		
		int result = sqlSession.update("member.updateMember",m);
		return result;
	}

	public int deleteMember(Member m) {
		
		int result =sqlSession.delete("member.deleteMember",m);
		return result;
	}

	public ArrayList<Member> searchMemberId(String keyword) {
		// TODO Auto-generated method stub
		
		List list = sqlSession.selectList("member.searchMemberId",keyword); 
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> getIdOrName(HashMap<String, Object> map) {
		
		List list = sqlSession.selectList("member.idOrName",map);
		return (ArrayList<Member>) list;
	}

	public ArrayList<Member> searchMember() {
		
		List list = sqlSession.selectList("member.searchMembers");
		return (ArrayList<Member>) list;
	}

	public ArrayList<Member> getMemberList(String[] memberId) {
		
		List list = sqlSession.selectList("member.getMemberList",memberId);
		return (ArrayList<Member>)list  ;
	}
}
